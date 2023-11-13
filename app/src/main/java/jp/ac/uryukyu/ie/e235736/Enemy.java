package jp.ac.uryukyu.ie.e235736;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if(dead==false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        this.setHitPoint(this.getHitPoint()-damage);
        if( hitPoint < 0 ) {
            this.setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

    //以下getter
    
    /**
     * nameのgetter
     * @return 名前
     */
    public String getName(){
        return this.name;
    }
    
    /** 
     * hitPointのgetter
     * @return HP
     */
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

    /**
     * deadのgetter
     * @return 生死状態。true=死亡。
     */
    public boolean getDead(){
        return this.dead;
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
}