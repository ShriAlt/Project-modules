<%@ page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
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

<!--        <div class="collapse navbar-collapse" id="navbarNav">-->
<!--            <ul class="navbar-nav ms-auto">-->
<!--                <li class="nav-item">-->
<!--                    <a class="nav-link" href="viewProfile">-->
<!--                        <i class="fas fa-user"></i> Profile-->
<!--                    </a>-->
<!--                </li>-->
<!--            </ul>-->
<!--        </div>-->
    </div>
</nav>


<!-- Content Area -->
<!-- Content Area -->
<div class="content">
    <div class="container">
        <h1>Welcome to our Game Store</h1>
        <p>This is where you'll find all the latest games!</p>

        <div class="card mt-4">
            <div class="card-header">
                User Profile
            </div>
            <div class="card-body">
                <form id="updateProfileForm" action="UpdateProfile" method="post" enctype="multipart/form-data">
<img src="getImage/${dto.fileName}">
                    <input type="text" class="form-control" id="id" name="id" value="${dto.id}" hidden>
                    <input type="text" class="form-control" id="password" name="password" value="${dto.password}" hidden>
                    <input type="text" class="form-control" id="confirmPassword" name="confirmPassword" value="${dto.password}" hidden>
                    <div class="mb-3">
                        <label for="firstName" class="form-label">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" value="${dto.firstName}" required>
                    </div>
                    <div class="mb-3">
                        <label for="lastName" class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" value="${dto.lastName}" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${dto.email}" required>
                    </div>
                    <div class="mb-3">
                        <label for="phoneNumber" class="form-label">Phone Number</label>
                        <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" value="${dto.phoneNumber}" required>
                    </div>
                    <div class="mb-3">
                        <label for="gender" class="form-label">Gender</label>
                        <input type="text" class="form-control" id="gender" name="gender" value="${dto.gender}" required>
                    </div>
                    <div class="mb-3">
                        <label for="country" class="form-label">Country</label>
                        <input type="text" class="form-control" id="country" name="country" value="${dto.country}" required>
                    </div>
                    <div class="mb-3">
                        <label for="state" class="form-label">State</label>
                        <input type="text" class="form-control" id="state" name="state" value="${dto.state}" required>
                    </div>
                    <div class="mb-3">
                        <label for="city" class="form-label">City</label>
                        <input type="text" class="form-control" id="city" name="city" value="${dto.city}" required>
                    </div>
                    <div class="mb-3">

                        <label for="dob" class="form-label">dob</label>
                        <input type="date" class="form-control" id="dob" name="dob" value="${dto.dob}" required>
                    </div>
                    <div class="mb-3">
                        <label for="pinCode" class="form-label">Pin Code</label>
                        <input type="text" class="form-control" id="pinCode" name="pinCode" value="${dto.pinCode}" required>
                    </div>
                    <input type="file" name="userImage" id="userImage" class="form-control mb-3" accept="image/*" />
                    <button type="submit" class="btn btn-primary">Update Profile</button>
                </form>
            </div>
        </div>
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
