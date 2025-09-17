<%@ page isELIgnored="false" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register | Game Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <style>
        body {
          min-height: 100vh;
          display: flex;
          flex-direction: column;
        }

        .content {
          flex: 1;
          display: flex;
          justify-content: center;
          align-items: center;
          padding: 30px 15px;
        }

        .register-card {
          width: 600px;
          max-width: 95%;
          border-radius: 15px;
          overflow: hidden;
        }

        .card-header {
          background: #2575fc;
          color: white;
          font-weight: bold;
          text-align: center;
          font-size: 1.25rem;
          padding: 15px;
        }

        .form-control:focus {
          box-shadow: none;
          border-color: #2575fc;
        }

        button {
          border-radius: 8px;
        }
    </style>
</head>

<body>

<!-- Main Content -->
<div class="content">
    <div class="card register-card shadow-lg">
        <div class="card-header">
            <i class="fas fa-user-plus me-2"></i> Create Your Account
        </div>
        <div class="card-body p-4">

            <form action="register" id="registrationForm" method="POST">
                <span class="text-danger">${error}</span>
                <span class="text-danger">${validationError}</span>
                <span class="text-danger">${passwordError}</span>
                <span class="text-danger">${emailError}</span>
                <div class="row">
                    <div class="mb-3 col-md-6">
                        <label for="firstName" class="form-label">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" onchange="validateName()"
                               placeholder="Enter first name" required>
                        <span id="firstNameError" class="text-danger"></span>
                    </div>

                    <div class="mb-3 col-md-6">
                        <label for="lastName" class="form-label">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" onchange="validateLastName()" placeholder="Enter last name"
                               required>
                        <span id="lastNameError" class="text-danger"></span>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email Address</label>
                    <input type="email" class="form-control" id="email" name="email" onchange="validateEmail()" placeholder="name@example.com" required>
                    <span id="emailError" class="text-danger"></span>
                </div>

                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Phone Number</label>
                    <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" onchange="validatePhoneNumber()" placeholder="Enter phone number" required>
                    <span id="phoneError" class="text-danger"></span>
                </div>

                <div class="mb-3">
                    <label for="dob" class="form-label">Date of Birth</label>
                    <input type="date" class="form-control" id="dob" name="dob" onchange="validateDOB()" required>
                    <span id="dateError" class="text-danger"></span>
                </div>

                <div class="mb-3">
                    <label class="form-label">Gender</label>
                    <span id="genderError" class="text-danger"></span>
                    <div class="d-flex gap-3">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="gender" id="genderMale" value="Male"
                                   onchange="validateGender()"
                                   required>
                            <label class="form-check-label" for="genderMale">Male</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="gender" id="genderFemale" value="Female"
                                   onchange="validateGender()"
                                   required>
                            <label class="form-check-label" for="genderFemale">Female</label>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="mb-3 col-md-6">
                        <label for="country" class="form-label">Country</label>
                        <span id="countryError" class="text-danger"></span>
                        <select class="form-select" id="country" name="country" onchange="validateCountry()" required>
                            <option value="">Select Country</option>
                            <option value="India">India</option>
                        </select>
                    </div>
                    <div class="mb-3 col-md-6">
                        <label for="state" class="form-label">State</label>
                        <span id="stateError" class="text-danger"></span>
                        <input type="text" class="form-control" id="state"
                               onchange="validateState()" name="state" placeholder="Enter state" required>
                    </div>
                </div>

                <div class="row">
                    <div class="mb-3 col-md-6">
                        <label for="city" class="form-label">City</label>
                        <input type="text" class="form-control" id="city" name="city" placeholder="Enter city" required>
                    </div>
                    <div class="mb-3 col-md-6">
                        <label for="pinCode" class="form-label">Pin Code</label>
                        <span id="pinCodeError" class="text-danger"></span>
                        <input type="text" class="form-control" id="pinCode" name="pinCode" placeholder="Enter pin code" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <span id="passwordError" class="text-danger"></span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" onchange="validatePasswords()" required>
                </div>

                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <span id="confirmPasswordError" class="text-danger"></span>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                           onchange="validatePasswords()"
                           placeholder="Re-enter password" required>
                </div>

                <button type="submit" class="btn btn-primary w-100" id="submitBtn" >Register</button>
                <p class="text-center mt-3 mb-0">
                    Already have an account? <a href="signIn" class="text-decoration-none">Login here</a>
                </p>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="Sign-up-validationns.js"></script>
</body>

</html>