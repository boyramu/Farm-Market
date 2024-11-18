<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload Animal Details</title>
    <link rel="stylesheet" href="style.css">  <!-- Link to your external CSS -->
</head>
<body>
    <h1>Upload Animal Details</h1>
    
    <form action="uploadAnimal" method="post" enctype="multipart/form-data">
        <label for="name">Animal Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="breed">Breed:</label>
        <input type="text" id="breed" name="breed"><br>

        <label for="age">Age (in years):</label>
        <input type="number" id="age" name="age" min="0"><br>

        <label for="price">Price ($):</label>
        <input type="number" id="price" name="price" step="0.01" min="0"><br>

        <label for="color">Color:</label>
        <input type="text" id="color" name="color"><br>

        <label for="contact">Contact Details:</label>
        <input type="text" id="contact" name="contact"><br>

        <label for="milkYield">Milk Yield (liters/day):</label>
        <input type="number" id="milkYield" name="milkYield" step="0.1"><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description"></textarea><br>

        <label for="image">Upload Image:</label>
        <input type="file" id="image" name="image" accept="image/*" required><br>

        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="GIVING_MILK">GIVING MILK</option>
            <option value="PREGNANT">PREGNANT</option>
            <option value="NOT_APPLICABLE">NOT APPLICABLE</option>
        </select><br>

        <input type="submit" value="Upload Animal">
    </form>

</body>
</html>
