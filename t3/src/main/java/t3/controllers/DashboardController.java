package t3.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

  @GetMapping("/")
  public String dashboard(Model model) {

    model.addAttribute("name", "JohnTenno");
    model.addAttribute("profilePictureUrl", "https://avatars.githubusercontent.com/u/131226056?v=4");

    model.addAttribute("steamGames", 323);
    model.addAttribute("archivements", 20129);
    model.addAttribute("friends", 2);
    model.addAttribute("money", 0);
    model.addAttribute("steamGamesOptions", List.of("view Games", "store"));
    model.addAttribute("archivementsOptions", List.of("view", "search"));
    model.addAttribute("friendsOptions", List.of("add", "Delete"));
    model.addAttribute("moneyOptions", List.of("add"));

    return "dashboard";
  }
}