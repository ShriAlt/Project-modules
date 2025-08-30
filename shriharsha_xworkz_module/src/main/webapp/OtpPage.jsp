<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP Verification</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            max-width: 400px;
            margin: 100px auto;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        #otp {
            letter-spacing: 10px; /* Adjust spacing between digits */
        }
    </style>
</head>
<body>

<div class="container">


    <div class="card">
        <h2 class="text-center mb-4">OTP Verification</h2>
        <p class="text-center">Please enter the 6-digit OTP sent to your email.</p>
        <form id="otpForm" action="verifyOtp" method="post">
            <span>${error}</span>
            <div class="mb-3">
                <label for="otp" class="form-label">OTP</label>
                <input type="text" class="form-control text-center" id="otp" name="otp"
                       maxlength="6" minlength="6" pattern="[0-9]{6}" required>
                <div class="invalid-feedback">Please enter a valid 6-digit OTP.</div>
            </div>
            <button type="submit" class="btn btn-primary w-100" name="verify">Verify</button>
        </form>
        <p class="text-center mt-3">
            Didn't receive the OTP? <a href="" id="resendOtp">Resend OTP</a>
        </p>
    </div>
</div>

<script>
<!--    document.getElementById('resendOtp').addEventListener('click', function(event) {-->
<!--        event.preventDefault(); // Prevent navigation-->
<!--        // Add code here to resend the OTP (AJAX request to your server)-->
<!--        alert('Resending OTP...'); // Placeholder-->
<!--    });-->

    // Form validation
    (() => {
        const form = document.getElementById('otpForm');
        form.addEventListener('submit', (event) => {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        });
    })();
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
