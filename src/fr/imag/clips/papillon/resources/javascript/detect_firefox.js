function hideGetFirefoxIfAlreadyAvailable() {
    if (navigator.userAgent.indexOf("Firefox") != -1) {
        // Hide the get firefox div
        firefoxElement = document.getElementById("firefox"); 
        firefoxElement.style.display = "none";
    }
}