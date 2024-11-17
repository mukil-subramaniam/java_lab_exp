package com.example.Application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String showForm(@RequestParam(value = "number", required = false) Integer number) {
        String result = "";
        if (number != null) {
            if (number < 0) {
                result = "<p style='color: red; font-weight: bold; font-size: 20px;'>Factorial is not defined for negative numbers!</p>";
            } else {
                long factorial = 1;
                for (int i = 1; i <= number; i++) {
                    factorial *= i;
                }
                result = "<p style='color: green; font-weight: bold; font-size: 20px;'>Factorial of " + number + " is: "
                        + factorial + "</p>";
            }
        }

        return "<html>" +
                "<head>" +
                "<title>Factorial Calculator</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; background-color: #f4f4f9; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }"
                +
                ".container { text-align: center; background: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }"
                +
                "h1 { color: #4caf50; }" +
                "input[type='number'] { padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 5px; width: 200px; margin-bottom: 10px; }"
                +
                "button { background-color: #4caf50; color: white; border: none; padding: 10px 20px; font-size: 16px; border-radius: 5px; cursor: pointer; }"
                +
                "button:hover { background-color: #45a049; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<h1>Factorial Calculator</h1>" +
                "<form method='get' action='/'>" +
                "<input type='number' name='number' placeholder='Enter a number' required>" +
                "<br>" +
                "<button type='submit'>Calculate</button>" +
                "</form>" +
                result +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
