<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            height: 100vh; /* Make the body take the full viewport height */
            margin: 0;
            display: flex;
            flex-direction: column;
        }

        .navbar-brand img {
            height: 40px;
            margin-right: 8px;
        }

        /* Sticky Footer Styles */
        .content {
            flex: 1; /*  This makes the content area take up the available space */
        }

        footer {
            /* Optional: Add a background color to the footer for better visibility */
            background-color: #f8f9fa; /* Match to body's background or choose a different one */
            padding: 20px 0; /* Add some padding to the top and bottom */
        }
    </style>
</head>

<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container">
        <a class="navbar-brand d-flex align-items-center" href="#">
            <img src="imgs/logo-hollowKnight.jpeg" alt="Logo">
            <strong>Game Store</strong>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a href="signIn" class="btn btn-outline-primary nav-link">
                    <i class="fa fa-user"></i> Login
                </a>
            </li>
        </ul>
    </div>
</nav>

<!-- Content Area -->
<div class="content">
    <div class="container">
        <!-- Your main page content goes here -->
        <h1>Welcome to our Game Store</h1>
        <p>This is where you'll find all the latest games!</p>
        <!-- Add more content as needed -->
    </div>
</div>

<!-- Footer -->
<footer class="py-3 my-4">
    <div class="container">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Home</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Features</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Pricing</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">FAQs</a></li>
            <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">About</a></li>
        </ul>
        <p class="text-center text-body-secondary">© 2025 Shriharsha | Where Code Meets Character</p>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
