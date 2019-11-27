package node;
import ArrayListTest.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘建雯
 */

public class HeroNode {
    public HeroNode leftNode;
    public HeroNode rightNode;
    public Hero hero;

    public void add(Hero h){
        if(null == hero){
            hero = h;
        }else{
            if(h.hp <= hero.hp){
                if(null == leftNode){
                    leftNode = new HeroNode();
                }
                leftNode.add(h);
            }else{
                if(null == rightNode){
                    rightNode = new HeroNode();
                }
                rightNode.add(h);
            }
        }
    }

    public List<Hero> values(){
        List<Hero> list = new ArrayList<>();
        if(null != leftNode){
            list.addAll(leftNode.values());
        }
        list.add(hero);
        if(null != rightNode){
            list.addAll(rightNode.values());
        }
        return list;
    }

    public static void main(String[] args) {
        String[] heroName = {"invoker","silencer","spiritBreaker","shadowFiend","antiMage"};
        int[] heroHp = {580,560,650,480,500};
        Hero[] heroes = new Hero[5];
        for(int i=0;i<heroName.length;i++){
            heroes[i] = new Hero(heroName[i],heroHp[i]);
        }
        HeroNode heroNode = new HeroNode();
        for(Hero value:heroes){
            heroNode.add(value);
        }
        List<Hero> list = heroNode.values();
        for(Hero value:list){
            System.out.println(value);
        }
    }
}
