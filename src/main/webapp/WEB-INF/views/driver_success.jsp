<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Include SweetAlert CSS and JavaScript -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
    <!-- Your success page content -->
    <script>
        // Display SweetAlert with success message
        Swal.fire({
            icon: 'success',
            title: 'Success!',
            text: 'Driver has successfully registered!',
            onClose: () => {
                window.location.href = '/index.html'; // Redirect to index.html after alert is closed
            }
        });
    </script>
</body>
</html>
