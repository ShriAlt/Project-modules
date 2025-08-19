<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Navbar with Sign In & Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
          font-family: Arial, sans-serif;
          padding-top: 60px;
        }
        .navbar-brand {
          font-weight: bold;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top shadow">
    <div class="container">
        <a class="navbar-brand" href="#">MyWebsite</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item me-2">
                    <button class="btn btn-outline-light" data-bs-toggle="modal" data-bs-target="#signinModal">Sign In</button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#signupModal">Sign Up</button>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Sign In Modal -->
<div class="modal fade" id="signinModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content rounded-3 shadow">
            <div class="modal-header">
                <h5 class="modal-title">Sign In</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form id="signinForm">
                    <div class="mb-3">
                        <label for="signinEmail" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="signinEmail" required>
                    </div>
                    <div class="mb-3">
                        <label for="signinPassword" class="form-label">Password</label>
                        <input type="password" class="form-control" id="signinPassword" required>
                    </div>
                    <button type="submit" class="btn btn-dark w-100">Sign In</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Sign Up Modal -->
<div class="modal fade" id="signupModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content rounded-3 shadow">
            <div class="modal-header">
                <h5 class="modal-title">Sign Up</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form id="signupForm">
                    <div class="mb-3">
                        <label for="signupName" class="form-label">Full Name</label>
                        <input type="text" class="form-control" id="signupName" required>
                    </div>
                    <div class="mb-3">
                        <label for="signupEmail" class="form-label">Email address</label>
                        <input type="email" class="form-control" id="signupEmail" required>
                    </div>
                    <div class="mb-3">
                        <label for="signupPassword" class="form-label">Password</label>
                        <input type="password" class="form-control" id="signupPassword" required>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Sign Up</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script>
    document.getElementById("signinForm").addEventListener("submit", function(e){
      e.preventDefault();
      alert("Sign In Successful!");
      var modal = bootstrap.Modal.getInstance(document.getElementById('signinModal'));
      modal.hide();
    });

    document.getElementById("signupForm").addEventListener("submit", function(e){
      e.preventDefault();
      alert("Sign Up Successful!");
      var modal = bootstrap.Modal.getInstance(document.getElementById('signupModal'));
      modal.hide();
    });
</script>
</body>
</html>

