<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Bienvenida a la EPN</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="estilos/styles.css">
    <style>
        html, body {
            height: 100%;
            margin: 0;
        }
        .hero {
            position: relative;
            height: 400px;
            overflow: hidden;
        }
        .hero img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
        .hero-overlay {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 139, 0.7);
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            text-align: center;
            padding: 20px;
        }
        .container {
            padding: 20px;
        }
        .section-title {
            margin: 40px 0 20px;
            text-align: center;
            font-size: 1.5rem;
            color: #2d3748;
        }
        .separator {
            height: 2px;
            width: 100px;
            background-color: #2d3748;
            margin: 0 auto;
            margin-bottom: 20px;
        }
        .card {
            background: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            margin: 10px;
        }
        .icon {
            margin-right: 10px;
        }
        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
        }
        .footer {
            background-color: #2d3748;
            color: white;
            padding: 0.001rem;
            text-align: center;
            font-size: 0.875rem;
        }
    </style>
    <%@ include file="header.jsp" %>
</head>
<body>
<div class="hero">
    <img src="https://images.unsplash.com/photo-1562774053-701939374585?auto=format&fit=crop&q=80&w=1200&h=400" alt="EPN Campus">
    <div class="hero-overlay">
        <h1>Escuela Politécnica Nacional</h1>
        <p> Excelencia en Ciencia y Tecnología al Servicio del País</p>
    </div>
</div>

<div class="container">
    <!-- Separador y Servicios Ofrecidos -->
    <div class="section-title">Servicios Ofrecidos</div>
    <div class="separator"></div>

    <div class="grid">
        <div class="card">
            <h2><i class="fas fa-bus icon"></i>Polibus</h2>
            <p>Servicio de transporte interno para facilitar la movilidad de estudiantes y personal dentro del campus.</p>
        </div>
        <div class="card">
            <h2><i class="fas fa-coffee icon"></i>Cafetería</h2>
            <p>Espacios de alimentación con menús variados y saludables, disponibles para toda la comunidad.</p>
        </div>
        <div class="card">
            <h2><i class="fas fa-handshake icon"></i>Asociaciones</h2>
            <p>Grupos estudiantiles y asociaciones para fomentar el crecimiento académico y personal de los estudiantes.</p>
        </div>
        <div class="card">
            <h2><i class="fas fa-users icon"></i>Área Social</h2>
            <p>Espacios recreativos y de esparcimiento para el bienestar de la comunidad universitaria.</p>
        </div>
    </div>
    <div class="section-title">Misión y Visión</div>
    <div class="separator"></div>
    <!-- Misión y Visión -->
    <div class="grid">
        <div class="card">
            <h2><i class="fas fa-bullseye icon"></i>Misión</h2>
            <p>Formar profesionales altamente calificados en ciencia y tecnología, capaces de contribuir al desarrollo del país con responsabilidad y ética.</p>
        </div>
        <div class="card">
            <h2><i class="fas fa-eye icon"></i>Visión</h2>
            <p>Ser una institución de educación superior líder en investigación e innovación, reconocida a nivel nacional e internacional por su excelencia académica.</p>
        </div>
    </div>

    <div class="section-title">Información General</div>
    <div class="separator"></div>
    <!-- Información general -->
    <div class="grid">
        <div class="card">
            <h2><i class="fas fa-book-open icon"></i>Nuestra Historia</h2>
            <p>Fundada en 1869, la EPN ha sido pionera en la educación técnica y científica en Ecuador. Con más de 150 años de excelencia académica, seguimos formando profesionales de alto nivel.</p>
        </div>
        <div class="card">
            <h2><i class="fas fa-award icon"></i>Excelencia Académica</h2>
            <p>Reconocida como una de las mejores universidades del país, ofrecemos programas de pregrado y postgrado en ingeniería, ciencias y tecnología.</p>
        </div>
        <div class="card">
            <h2><i class="fas fa-globe icon"></i>Impacto Global</h2>
            <p>Colaboramos con universidades internacionales y participamos en investigaciones de alcance mundial.</p>
        </div>
        <div class="card">
            <h2><i class="fas fa-users icon"></i>Comunidad Estudiantil</h2>
            <p>Más de 10,000 estudiantes forman parte de nuestra vibrante comunidad académica.</p>
        </div>
        <div class="card">
            <h2><i class="fas fa-building icon"></i>Infraestructura</h2>
            <p>Modernos laboratorios y espacios de investigación equipados con tecnología de punta.</p>
        </div>
    </div>


</div>

<footer class="footer">
    <%@ include file="footer.jsp" %>
</footer>

</body>
</html>
