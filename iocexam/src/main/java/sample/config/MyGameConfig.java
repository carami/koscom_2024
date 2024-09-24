package sample.config;

import org.springframework.context.annotation.Bean;
import sample.bean.Dice;
import sample.bean.Game;
import sample.bean.Player;

import java.util.List;

public class MyGameConfig {
    @Bean
    public Dice dice(){
        return new Dice(6);
    }
    @Bean
    public Player kang(Dice dice){
        Player player = new Player();
        player.setDice(dice);   //dice 를 주입하고 있는 코드..(설정자방식으로 주입!!)
        player.setName("강경미");
        return player;
    }
    @Bean
    public Player kim(Dice dice){
        Player player = new Player();
        player.setDice(dice);   //dice 를 주입하고 있는 코드..(설정자방식으로 주입!!)
        player.setName("김둘리");
        return player;
    }
    @Bean
    public Player hong(Dice dice){
        Player player = new Player();
        player.setDice(dice);   //dice 를 주입하고 있는 코드..(설정자방식으로 주입!!)
        player.setName("홍길동");
        return player;
    }
    @Bean
    public Player lee(Dice dice){
        Player player = new Player();
        player.setDice(dice);   //dice 를 주입하고 있는 코드..(설정자방식으로 주입!!)
        player.setName("이또치");
        return player;
    }
    @Bean
    public Game game(List<Player> players){
        Game game = new Game();
        game.setPlayerList(players);
        return game;
    }
}
