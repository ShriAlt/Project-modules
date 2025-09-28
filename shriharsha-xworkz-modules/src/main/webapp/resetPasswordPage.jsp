<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Reset Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .reset-password-container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .reset-password-card {
            width: 400px;
            max-width: 90%;
        }
    </style>
</head>
<body>
<div class="reset-password-container">
    <div class="card reset-password-card">
        <div class="card-header text-center">
            <h3>Reset Your Password</h3>
        </div>
        <div class="card-body">
            <form id="resetPasswordForm" action="ResetPassword" method="post">
                <div class="mb-3">

                    <input type="text" name="email" value="${email}" hidden>
                    <label for="newPassword" class="form-label">New Password</label>
                    <input type="password" class="form-control" id="newPassword" name="newPassword" required>
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm New Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Reset Password</button>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
