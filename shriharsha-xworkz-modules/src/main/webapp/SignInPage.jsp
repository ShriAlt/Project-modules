<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | My Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <style>
        body {
          /* background: linear-gradient(135deg, #6a11cb, #2575fc); */
          height: 100vh;
          display: flex;
          justify-content: center;
          align-items: center;
        }

        .login-card {
          width: 400px;
          max-width: 90%;
          border-radius: 15px;
        }

        .form-control:focus {
          box-shadow: none;
          border-color: #2575fc;
        }
    </style>
</head>

<body>

<!-- Login Form (Card) -->
<div class="card login-card shadow-lg">
    <div class="card-header text-center bg-primary text-white fw-bold">
        <i class="fas fa-user-circle me-2"></i> Login
    </div>
    <div class="card-body p-4">
        <form action="/login" method="POST">

            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                    <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                </div>
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
            </div>

            <div class="d-flex justify-content-between align-items-center mb-3">
                <!-- <div class="form-check">
                  <input class="form-check-input" type="checkbox" id="rememberMe">
                  <label class="form-check-label" for="rememberMe"> Remember Me </label>
                </div> -->
                <a href="#" class="small text-decoration-none">Forgot Password?</a>
            </div>

            <button type="submit" class="btn btn-primary w-100">Login</button>
        </form>
        <p class="text-center mt-3 mb-0">
            Don’t have an account? <a href="signUp" class="text-decoration-none">Register here</a>
        </p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
