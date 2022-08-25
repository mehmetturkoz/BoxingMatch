public class Match {

    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() {
        if (isStart()) {
            if (isCheck()) {
                while (this.f1.health > 0 && this.f2.health > 0) {
                    System.out.println("======YENİ ROUND=====");
                    this.f2.health = this.f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    this.f1.health = this.f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    System.out.println(this.f1.name + " Sağlık :" + this.f1.health);
                    System.out.println(this.f2.name + " Sağlık :" + this.f2.health);
                }
            } else {
                System.out.println("Sporcularin sikletleri uymuyor.");
            }
        } else {
            if (isCheck()) {
                while (this.f1.health > 0 && this.f2.health > 0) {
                    System.out.println("======YENİ ROUND=====");
                    this.f1.health = this.f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    this.f2.health = this.f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    System.out.println(this.f1.name + " Sağlık :" + this.f1.health);
                    System.out.println(this.f2.name + " Sağlık :" + this.f2.health);
                }
            } else {
                System.out.println("Sporcularin sikletleri uymuyor.");
            }
        }
    }




    private boolean isCheck() {
        return (this.f1.weight>=minWeight  &&  this.f1.weight<=maxWeight) && (this.f2.weight>=minWeight  &&  this.f2.weight<=maxWeight);
    }

    boolean isWin(){
        if(this.f1.health==0){
            System.out.println("KAZANAN DÖVÜŞCÜ:"+this.f2.name);
            return true;
        }
       if(this.f2.health==0){
           System.out.println("KAZANAN DÖVÜŞÇÜ:"+this.f1.name);
           return true;
       }
       return false;
    }

    boolean isStart(){
        double ramdomStart=Math.random()*100;
        return ramdomStart<=50;
    }
}
