// 1

console.log("1:");

function countPoints(kPiste, lisapisteet) {
  return function(pituus) {
    let ero = (pituus - kPiste) * lisapisteet;
    return 60 + ero;
  }
}

let pituudet = [75, 80, 85, 90, 95, 100];
let pisteet = pituudet.map(countPoints(88, 1.8));
console.log(pisteet);


// 2

console.log("2:");

const Auto = (function() {
  const suojatut = new WeakMap();

  class Auto {
    constructor(p_tankki, p_matkamittari) {
      this.tankki = p_tankki;
      suojatut.set(this, {matkamittari: p_matkamittari});
    }
    
    getTankki() {
      return this.tankki;
    }
    
    getMatkamittari() {
      return suojatut.get(this).matkamittari;
    }
    
    aja() {
      this.tankki--;
      suojatut.set(this, {matkamittari: this.getMatkamittari() + 1});
    }
    
    tankkaa() {
      this.tankki++;
    }
    
    log() {
      console.log("Tankki: " +  this.getTankki() + ", Mittari: " + this.getMatkamittari());
    }
  }
  
  return Auto;
})();

const auto = new Auto(10, 0);
auto.log();
auto.aja();
auto.log();
auto.tankkaa();
auto.log();
auto.tankki = 100;
auto.log();

function MuuttumatonAuto(tankki, mittari) {
  let _tankki = tankki;
  let _mittari = mittari;
  
  return {
    tankki: function() {return _tankki;},
    mittari: function() {return _mittari;},
    aja: function() {return MuuttumatonAuto(_tankki - 1, _mittari + 1);},
    tankkaa: function() {return MuuttumatonAuto(_tankki + 1, _mittari);},
    toString: function() {return "Tankki: " + _tankki + ", Mittari: " + _mittari;}
  }
}


// 3

console.log("3:");
var auto2 = new MuuttumatonAuto(10, 0);
console.log(auto2.toString());
auto2 = auto2.aja();
console.log(auto2.toString());
auto2 = auto2.tankkaa();
console.log(auto2.toString());
auto2.tankki = 100;
console.log(auto2.toString());


// 4

console.log("4:");

const set1 = Immutable.Set(('Punainen', 'Vihreä', 'Keltainen'));
const set2 = set1 & 'Ruskea';
console.log(set1 === set2); // false
const set3 = set2 & 'Ruskea';
console.log(set2 === set3); // true - Set ei hyväksy duplikaatteja