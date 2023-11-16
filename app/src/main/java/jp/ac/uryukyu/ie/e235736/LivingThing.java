package jp.ac.uryukyu.ie.e235736;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;//maximumHPとすることでhitPointがローカルとメンバで被らない。そのためthis.はいらない。
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    //以下getter

    public boolean isDead(){ // deadの getter method。booleanの場合にはisを使うことが多い。
        return dead;
    }

    public String getName(){
        return this.name;
    }

    public int getHitPoint(){
        return this.hitPoint;
    }

     /**
     * attackのgetter
     * @return 攻撃力
     */
    public int getAttack(){
        return this.attack;
    }


    
    //以下setter

    /**
     * nameのsetter
     * @param name 設定したい名前
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * hitPointのsetter
     * @param hitPoint 設定したいHP
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint=hitPoint;
    }

    /**
     * attackのsetter
     * @param attack 設定したい攻撃力
     */
    public void setAttack(int attack){
        this.attack=attack;
    }

    /**
     * deadのsetter
     * @param dead 設定したい生死状態。true=死亡。
     */
    public void setDead(boolean dead){
        this.dead=dead;
    }


   
    public void attack(LivingThing opponent){
        if(dead==false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        hitPoint-=damage;
        if( hitPoint < 0 ) {
            dead=true;
            System.out.printf("%sは倒れた。\n", this.name);
        }
    }
}
