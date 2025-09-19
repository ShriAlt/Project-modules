<%@ page isELIgnored="false" %>
<html>
<head>
    <title>OTP Verification</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

    <style>
        body {
            background-color: #f8f9fa;
        }

        .card {
            border: none;
            box-shadow: 0 0.25rem 0.5rem rgba(0, 0, 0, 0.05); /* Subtle shadow */
        }

        .card-header {
            background-color: #fff;
            border-bottom: 1px solid #e9ecef;
            padding: 1rem 1.25rem;
        }

        .card-header h3 {
            font-size: 1.25rem;
            font-weight: 500;
            color: #343a40;
            margin-bottom: 0;
        }

        .form-control {
            border-radius: 0.25rem;
        }

        .form-label {
            font-weight: 500;
            color: #495057;
        }

        .btn {
            border-radius: 0.25rem;
        }
    </style>
</head>
<body>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">

                <!-- Email Form -->
                <div class="card mb-4">
                    <div class="card-header text-center">
                        <h3>Send OTP</h3>
                    </div>
                    <div class="card-body">
                        <form id="emailForm" method="post" action="SendOtp">
                            <div class="mb-3">
                                <label for="email" class="form-label" >Enter Email</label>
                                <input type="email" class="form-control" id="email" name="email" value="${email}" onchange="validateEmail()" required placeholder="you@example.com">
                            </div>
                            <span id="emailError" class="text-danger"></span>
                            <button type="submit" class="btn btn-success w-100" id="otpButton">Send OTP</button>
                        </form>
                    </div>
                </div>

                <!-- OTP Verification Form -->
                <div class="card">
                    <div class="card-header text-center">
                        <h3>Verify OTP</h3>
                    </div>
                    <div class="card-body">
                        <form id="otpForm" method="post" action="VerifyOtp">
                            <div class="mb-3">
                                <input type="text" name="email" value="${email}" hidden>
                                <label for="otp" class="form-label">Enter OTP</label>
                                <input type="text" class="form-control" id="otp" name="otp" required pattern="\d{6}" title="Please enter a 6-digit OTP">
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Verify OTP</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="OtpPageValidation.js"></script>
</body>
</html>
