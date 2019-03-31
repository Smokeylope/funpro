let movies = [ 
		{ 
 			title: 'Harry Potter and the Deathly Hallows: Part 2', 
 			director: 'David Yates', 
 			release: 2011  
 		},
 		{ 
 			title: 'The Lord of the Rings: The Fellowship of the Ring', 
 			director: 'Peter Jackson', 
 			release: 2001  
 		}, 
 		{ 
 			title: 'Titanic', 
 			director: 'James Cameron', 
 			release: 1997 
 		}, 
 		{ 
 			title: 'Avatar', 
 			director: 'James Cameron', 
 			release: 2009 
 		}, 
 		{ 
 			title: 'The Hobbit: An Unexpected Journey', 
 			director: 'Peter Jackson', 
 			release: 2012 
 		}, 
 		{ 
 			title: 'The Matrix', 
 			director: 'Andy Wachowski', 
 			release: 1999 
 		}, 
 		{ 
 			title: 'Inception', 
 			director: 'Christopher Nolan', 
 			release: 2010 
 		}, 
 		{ 
 			title: 'The Town', 
 			director: 'Ben Affleck', 
 			release: 2010 
 		}, 
 		{ 
 			title: 'The Dark Knight Rises', 
 			director: 'Christopher Nolan', 
 			release: 2012 
 		}, 
 		{ 
 			title: 'My Neighbor Totoro', 
 			director: 'Hayao Miyazaki', 
 			release: 1988 
 		}, 
 		{ 
 			title: 'Spirited Away', 
 			director: 'Hayao Miyazaki', 
 			release: 2001 
 		} 
]

let kalevala = "Mieleni minun tekevi, aivoni ajattelevi lähteäni laulamahan, saa'ani sanelemahan, sukuvirttä suoltamahan, lajivirttä laulamahan. Sanat suussani sulavat, puhe'et putoelevat, kielelleni kerkiävät, hampahilleni hajoovat.\nVeli kulta, veikkoseni, kaunis kasvinkumppalini! Lähe nyt kanssa laulamahan, saa kera sanelemahan yhtehen yhyttyämme, kahta'alta käytyämme! Harvoin yhtehen yhymme, saamme toinen toisihimme näillä raukoilla rajoilla, poloisilla Pohjan mailla.\n\nLyökämme käsi kätehen, sormet sormien lomahan, lauloaksemme hyviä, parahia pannaksemme, kuulla noien kultaisien, tietä mielitehtoisien, nuorisossa nousevassa, kansassa kasuavassa: noita saamia sanoja, virsiä virittämiä vyöltä vanhan Väinämöisen, alta ahjon Ilmarisen, päästä kalvan Kaukomielen, Joukahaisen jousen tiestä, Pohjan peltojen periltä, Kalevalan kankahilta.\n\nNiit' ennen isoni lauloi kirvesvartta vuollessansa; niitä äitini opetti väätessänsä värttinätä, minun lasna lattialla eessä polven pyöriessä, maitopartana pahaisna, piimäsuuna pikkaraisna. Sampo ei puuttunut sanoja eikä Louhi luottehia: vanheni sanoihin sampo, katoi Louhi luottehisin, virsihin Vipunen kuoli, Lemminkäinen leikkilöihin.\nViel' on muitaki sanoja, ongelmoita oppimia: tieohesta tempomia, kanervoista katkomia, risukoista riipomia, vesoista vetelemiä, päästä heinän hieromia, raitiolta ratkomia, paimenessa käyessäni, lasna karjanlaitumilla, metisillä mättähillä, kultaisilla kunnahilla, mustan Muurikin jälessä, Kimmon kirjavan keralla."

// 1

console.log("1:");

let fahrenheit = 100;
let toCelsius = fahrenheit => (5/9) * (fahrenheit - 32);
console.log(toCelsius(fahrenheit));

let radius = 10;
let area = radius => Math.PI * radius * radius;
console.log(area(radius));


// 2

console.log("2:");

let removeDirector = function(movie) {
  return [movie.title, movie.release];
}

let mappedMovies = movies.map(movie => [movie.title, movie.release]);
console.log("Mapped");
console.log(mappedMovies);


// 3

console.log("3:");

let recentMovies = movies.filter(movie => movie.release > 2011);
console.log(recentMovies);


// 4

console.log("4:");

let tempsA = [-20, -10, 0, 10, 15, 20, 20, 15, 10, 10, -10, -15];
let tempsB = [-30, -20, 0, 15, 20, 25, 30, 20, 10, 0, -10, -20];
let tempsCombined = tempsA.concat(tempsB);
let tempsPositive = tempsCombined.filter(temp => temp >= 0);
let positiveAverage = tempsPositive.reduce((acc, temp, i, arr) => acc + temp / arr.length);
console.log(positiveAverage);


// 5

console.log(5);

let words = kalevala.toLowerCase().match(/\b[^,. ]+/g);

let getWordCounts = function(word, index, array) {
  return word + ": " + array.reduce(getCounter(word), 0);
}

let getCounter = function(word) {
  return function (acc, value, index, array) {
    if (value === word) {
      return acc + 1;
    }
    
    return acc;
  }  
}

let removeDuplicates = function(word, index, array) {
  return array.indexOf(word) === index;
}

console.log(words.map(getWordCounts).filter(removeDuplicates).sort());