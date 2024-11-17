<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asociación de Estudiantes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body class="bg-gray-50">  
<div class="space-y-8">
    <div class="bg-white p-6 rounded-lg shadow-lg">
        <div class="flex items-center mb-6">
            <img src="${pageContext.request.contextPath}/imagenes/AEIS.png" alt="Logo AEIS" class="mr-3 rounded-full" width="32" height="32">
            <div>
                <h2 class="text-2xl font-bold">AEIS - Asociación de Estudiantes de Ingeniería en Sistemas</h2>
                <p class="text-gray-600">Únete a nuestra comunidad y disfruta de beneficios exclusivos</p>
            </div>
        </div>

        <div class="mb-6">
            <h3 class="text-xl font-bold mb-2">Misión</h3>
            <p>Somos una organización estudiantil comprometida con el desarrollo integral de los estudiantes de Ingeniería en Sistemas de la EPN, a través de la generación de espacios académicos, de integración y de vinculación con la sociedad, que contribuyan a su formación profesional y personal.</p>

            <h3 class="text-xl font-bold mb-2 mt-4">Servicios</h3>
            <ul class="list-disc list-inside">
                <li>Asesorías académicas</li>
                <li>Talleres y cursos</li>
                <li>Organización de eventos</li>
                <li>Representación estudiantil</li>
            </ul>

            <h3 class="text-xl font-bold mb-2 mt-4">Contacto</h3>
            <p>Correo electrónico: asociacion.sistemas@epn.edu.ec</p>
            <p class="text-gray-600">Redes sociales:</p>
            <div class="flex space-x-4">
                <a href="https://www.facebook.com/AEIS.FIS.EPN/" target="_blank">
                    <img src="${pageContext.request.contextPath}/imagenes/facebook-icon.png" alt="Facebook AEIS" class="w-6 h-6">
                </a>
                <a href="https://www.instagram.com/aeis_epn?utm_source=ig_web_button_share_sheet&igsh=ZDNlZDc0MzIxNw==" target="_blank">
                    <img src="${pageContext.request.contextPath}/imagenes/instagram-icon.png" alt="Instagram AEIS" class="w-6 h-6">
                </a>
            </div>
            <p class="text-gray-600">Página oficial de la FIS:</p>
            <div class="flex space-x-4">
                <a href="http://fis.epn.edu.ec/" target="_blank">
                    <img src="${pageContext.request.contextPath}/imagenes/fis-icon.png" alt="FIS" class="w-6 h-6">
                </a>
            </div>
        </div>

        <div class="flex items-center space-x-4 mb-6">
            <button id="sort-asc" class="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded">
                Menor a Mayor
            </button>
            <button id="sort-desc" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">
                Mayor a Menor
            </button>
        </div>


        <div class="grid md:grid-cols-3 gap-6 mb-6">
            <c:forEach var="plan" items="${planes}">
                <div class="border rounded-lg p-6 ${plan.id == selectedPlan.id ? 'border-blue-500 ring-2 ring-blue-500' : 'border-gray-200'} flex flex-col h-full" id="plan-${plan.id}">
                    <h3 class="text-xl font-bold mb-2">${plan.name}</h3>
                    <p class="text-3xl font-bold text-blue-600 mb-4">${plan.price} $</p>
                    <ul class="space-y-2 mb-6 flex-grow">
                        <c:forEach var="feature" items="${plan.features}">
                            <li class="flex items-start">
                                <svg xmlns="http://www.w3.org/2000/svg" class="text-green-500 mr-2 flex-shrink-0 mt-1" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M9 11l3 3l8-8"></path></svg>
                                <span>${feature}</span>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="mt-4 w-full text-center">
                        <form class="plan-form" action="asociaciones" method="POST">
                            <input type="hidden" name="planId" value="${plan.id}" />
                            <button type="submit" class="btn bg-blue-600 text-white p-4 rounded-lg hover:bg-blue-700 transition w-full">
                                Seleccionar Plan
                            </button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<div id="payment-info-container"></div>

<script>
    $(document).ready(function() {
        // Función para ordenar los planes por precio
        function sortPlans(order) {
            const container = $(".grid");
            const plans = container.children("div").get();

            plans.sort(function(a, b) {
                const priceA = parseFloat($(a).find("p.text-blue-600").text().replace("$", ""));
                const priceB = parseFloat($(b).find("p.text-blue-600").text().replace("$", ""));

                return order === "asc" ? priceA - priceB : priceB - priceA;
            });

            // Reordenar los elementos en el contenedor
            $.each(plans, function(index, plan) {
                container.append(plan);
            });
        }

        // Escuchadores para los botones de ordenamiento
        $("#sort-asc").click(function() {
            sortPlans("asc");
        });

        $("#sort-desc").click(function() {
            sortPlans("desc");
        });

        // Mantener el script original
        $("form").submit(function(event) {
            event.preventDefault();

            var planId = $(this).find("input[name='planId']").val();

            $.ajax({
                url: 'asociaciones',
                type: 'POST',
                data: { planId: planId },
                success: function(response) {
                    var plan = response.producto;
                    var paymentInfoHtml = `
                        <div class="bg-blue-50 p-6 rounded-lg border border-blue-200">
                            <div class="flex items-center mb-4">
                                <svg xmlns="http://www.w3.org/2000/svg" class="text-blue-600 mr-3" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                    <path d="M16 7V4a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v16a2 2 0 0 0 2-2v-3"></path>
                                </svg>
                                <h3 class="text-xl font-bold">Información de Pago</h3>
                            </div>
                            <p class="mb-2">Para completar tu suscripción al <strong>${plan.nombre}</strong>, realiza una transferencia o depósito por <strong>${plan.precio}</strong> a la siguiente cuenta:</p>
                            <div class="bg-white p-4 rounded-lg border border-blue-200">
                                <p class="font-semibold">Banco Pichincha</p>
                                <p>Cuenta Corriente: 2100012345</p>
                                <p>Nombre: AEIS-EPN</p>
                                <p>RUC: 1234567890001</p>
                            </div>
                            <p class="mt-4 text-sm text-gray-600">
                                Una vez realizado el pago, por favor envía el comprobante al correo <a href="mailto:aeis@epn.edu.ec">aeis@epn.edu.ec</a>
                            </p>
                        </div>
                    `;

                    $("#payment-info-container").html(paymentInfoHtml);

                    $("div[id^='plan-']").removeClass('border-blue-500 ring-2 ring-blue-500').addClass('border-gray-200');
                    $("#plan-" + planId).removeClass('border-gray-200').addClass('border-blue-500 ring-2 ring-blue-500');
                    document.getElementById("payment-info-container").scrollIntoView({ behavior: 'smooth' });
                },
                error: function() {
                    alert('Hubo un error al seleccionar el plan.');
                }
            });
        });
    });
</script>

</body>
</html>