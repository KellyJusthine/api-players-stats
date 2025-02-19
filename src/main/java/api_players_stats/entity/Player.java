package api_players_stats.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
public class Player {

    @Id
    @Column(name = "name", unique = true)
    private String name;

    private Integer age;

    private Double height;

    private String nation;

    private String pos; // position - posição

    private Integer shirtNumber;

    private Integer gls;

    private Integer ast;

    private Integer mp; // matches played - partidas jogadas

    private Double glsConceded; // goals conceded - gols sofridos

    private Double saves; // saves made - defesas realizadas

    private Integer yellowCards;

    private Integer redCards;

    public Player() {
    }

    public Player(String name, Integer age, Double height, String nation, String pos, Integer shirtNumber, Integer gls,
                  Integer ast, Integer mp, Double glsConceded, Double saves, Integer yellowCards, Integer redCards) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.nation = nation;
        this.pos = pos;
        this.shirtNumber = shirtNumber;
        this.gls = gls;
        this.ast = ast;
        this.mp = mp;
        this.glsConceded = glsConceded;
        this.saves = saves;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public Integer getGls() {
        return gls;
    }

    public void setGls(Integer gls) {
        this.gls = gls;
    }

    public Integer getAst() {
        return ast;
    }

    public void setAst(Integer ast) {
        this.ast = ast;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Double getGlsConceded() {
        return glsConceded;
    }

    public void setGlsConceded(Double glsConceded) {
        this.glsConceded = glsConceded;
    }

    public Double getSaves() {
        return saves;
    }

    public void setSaves(Double saves) {
        this.saves = saves;
    }

    public Integer getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(Integer yellowCards) {
        this.yellowCards = yellowCards;
    }

    public Integer getRedCards() {
        return redCards;
    }

    public void setRedCards(Integer redCards) {
        this.redCards = redCards;
    }
}