package com.app.controllers;

import com.app.models.CalcModel;
import com.app.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalcController {

  @Autowired
  private CalculatorService calculatorService;

  @GetMapping("/eco")
  public String Eco() {
    return "uwu";
  }

  @GetMapping("/post")
  public String hello(
      @RequestParam(value = "name", defaultValue = "World") String name) {
    return "Hello, " + name + "! ";
  }

  @PostMapping("/{operation}")
  public ResponseEntity<CalcModel> calculator(
      @RequestBody CalcModel requestBody,
      @PathVariable String operation) {

    try {
      requestBody.setOperation(operation);

      CalcModel result = calculatorService.calculate(requestBody);
      return ResponseEntity.ok(result);

    } catch (Exception e) {
      CalcModel error = new CalcModel(0, 0, "error");
      error.setMessage("Error: " + e.getMessage());
      return ResponseEntity.badRequest().body(error);
    }
  }

}