package com.app.services;

import com.app.models.CalcModel;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

  public CalcModel calculate(CalcModel model) {
    String operation = model.getOperation().toLowerCase();
    int result = 0;
    String message = "";

    switch (operation) {
      case "suma":
        result = model.getA() + model.getB();
        message = String.format("%d + %d = %d", model.getA(), model.getB(), result);
        break;

      case "resta":
        result = model.getA() - model.getB();
        message = String.format("%d - %d = %d", model.getA(), model.getB(), result);
        break;

      case "multiplicacion":
        result = model.getA() * model.getB();
        message = String.format("%d × %d = %d", model.getA(), model.getB(), result);
        break;

      case "division":
        if (model.getB() != 0) {
          result = model.getA() / model.getB();
          message = String.format("%d ÷ %d = %d", model.getA(), model.getB(), result);
        } else {
          message = "nel";
          result = 0;
        }
        break;

      default:
        message = "dame una operacion valida :v";
        result = 0;
    }

    model.setResult(result);
    model.setMessage(message);

    return model;
  }

  public CalcModel calculate(int a, int b, String operation) {
    CalcModel model = new CalcModel(a, b, operation);
    return calculate(model);
  }
}