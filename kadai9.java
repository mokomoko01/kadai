public class TheDogTest1 {
 public static void main(String[] args) {
 Dog pochi = new Dog();
 pochi.print();
 pochi.roudou();
 pochi.print();
 pochi.roudou();
 pochi.print();
 pochi.shokuji();
 pochi.print();
 pochi.shokuji();
 pochi.print();
 }
}



class Dog {   //犬
 private DogState myState;
 public Dog () {
 myState =FutsuuState.getInstance();
 }
 public void roudou() {
 myState.tukareta(this);
 }
 public void kuufuku() {
 myState.tabeta(this);
 }
 public void shokuji() {
 myState.manpuku(this);
 }
 public void changeState(DogState d) {
 myState = d;
 }
}

abstract class DogState {    //犬の気持ち
public abstract void tukareta(Dog yobidashimoto);  //疲れた
public abstract void tabeta(Dog yobidashimoto);    //食べた
public abstract void manpuku(Dog yobidashimoto);    //満腹

}

class FutsuuState extends DogState {    //普通
public static FutsuuState s = new FutsuuState();
private FutsuuState() {}      // コンストラクタを隠蔽する
public static DogState getInstance() {
    return s;
   }
public void tukareta(Dog moto) {
  moto.changeState(IrairaState.getInstance());
}
public void tabeta(Dog moto) {
  moto.changeState(TanoshiiState.getInstance());
}
public void manpuku(Dog moto) {
  moto.changeState(NeteruState.getInstance());
}
public String toString() {
  return "普通状態";
}
}

class IrairaState extends DogState {    //イライラ
public static IrairaState s = new IrairaState();
private IrairaState() {}      // コンストラクタを隠蔽する
public static DogState getInstance() {
    return s;
   }
public void tukareta(Dog moto) {
}
public void tabeta(Dog moto) {
  moto.changeState(TanoshiiState.getInstance());
}
public void manpuku(Dog moto) {
  moto.changeState(NeteruState.getInstance());
}
public String toString() {
  return "イライラ状態";
}
}

class TanoshiiState extends DogState {    //楽しい
public static TanoshiiState s = new TanoshiiState();
private TanoshiiState() {} // コンストラクタを隠蔽する
public static DogState getInstance() {
    return s;
   }
public void tukareta(Dog moto) {
  moto.changeState(IrairaState.getInstance());
}
public void tabeta(Dog moto) {
}
public void manpuku(Dog moto) {
  moto.changeState(NeteruState.getInstance());
}
public String toString() {
  return "楽しい状態";
}
}

class NeteruState extends DogState {    //寝てる
public static NeteruState s = new NeteruState();
private NeteruState() {} // コンストラクタを隠蔽する
public static DogState getInstance() {
    return s;
   }
public void tukareta(Dog moto) {
  moto.changeState(IrairaState.getInstance());
}
public void tabeta(Dog moto) {
}
public void manpuku(Dog moto) {
}
public String toString() {
  return "寝てる状態";
}
}
