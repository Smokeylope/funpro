// 1

function isPalindrome(string)
{
  if (string.length <= 1)
  {
    return true;
  }
  else if (string.charAt(0) != string.charAt(string.length - 1))
  {
    return false;
  }
  
  var substring = string.slice(1, -1);
  return isPalindrome(substring);
}

console.log(isPalindrome("test"));
console.log(isPalindrome("sokos"));
console.log(isPalindrome("imaami"));


// 2

function gcd(p, q)
{
  if (q == 0)
  {
    return p;
  }
  
  return gcd(q, p % q);
}

console.log(gcd(102,68));


// 3

function coprime(p, q)
{
  return (gcd(p, q) == 1);
}

console.log(coprime(35, 18))


// 4

function power(p, q)
{
  if (q == 1)
  {
    return p;
  }
  
  return p * power(p, q -1);
}

console.log(power(4, 4));


// 5

function reverse(array)
{
  if (array.length == 1)
  {
    return array;
  }
  else if (array.length == 0)
  {
    return [];
  }
  
  var first = array[0];
  var last = array[array.length - 1];
  
  array = reverse(array.slice(1, -1));
  array = array.concat(first);
  array.unshift(last);
  console.log(array);
  return (array);
}

console.log(reverse([0,1,2,3,4,5,6,7,8,9]));

