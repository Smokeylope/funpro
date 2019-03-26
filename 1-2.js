// 1

function getComparator()
{
  return function(a, b)
  {
    if (a > b)
    {
      return 1;
    }
    else if (a < b)
    {
      return -1;
    }
    
    return 0;
  }
}

var comparator = getComparator();
console.log(comparator(1, 2));


// 2

function getNumWarmer(comparator, tempsA, tempsB)
{
  var numWarmer = 0;
  
  for (i = 0; i < tempsA.length; i++)
  {
    if (comparator(tempsB[i], tempsA[i]) > 0)
    {
      numWarmer++;
    }
  }
  
  return numWarmer;
}

var tempsA = [-20, -10, 0, 10, 15, 20, 20, 15, 10, 10, -10, -15];
var tempsB = [-30, -20, 0, 15, 20, 25, 30, 20, 10, 0, -10, -20];
console.log(getNumWarmer(comparator, tempsA, tempsB));


// 3

const offset = [1,2];
const zoom = 2;
const phi = Math.PI;

const point = { x: 1, y: 1};

const pipeline  = [   // 2D-muunnoksia
    
    function translate(p){
        return { x: p.x + offset[0], y: p.y + offset[1] };
    },

    function scale(p){
        return { x: p.x * zoom, y: p.y * zoom};
    },
    
    function rotate(p){
        return { x: p.x * Math.cos(phi) - p.y * Math.sin(phi), y: p.x * Math.sin(phi) + p.y * Math.cos(phi) };
    }
];


function muunnos(point){
     for(let i=0; i<pipeline.length; i++){   
        point = pipeline[i](point);
    }
    return point;
}


console.log(point);
console.log(muunnos(point));


// 4

function power(p, q)
{
  function powerHelper(p, q)
  {
    if (q == 1)
    {
      return p;
    }
    
    return p * powerHelper(p, q - 1);
  }
  
  return powerHelper(p, q);
}

console.log(power(4, 4));