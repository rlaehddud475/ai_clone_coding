package org.koreait.game.controllers;


import lombok.RequiredArgsConstructor;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final Utils utils;

    @GetMapping("/game")
    public String game(Model model) {
        model.addAttribute("addCss", "game/style");
        return utils.tpl("game/game");
    }


}
