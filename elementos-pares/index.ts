export default function filtrarPares(array: number[]): number[] {
  const frecuencia:{[key:number]:number}={};
  // TODO: implement
  array.forEach(element => {
    frecuencia[element] = (frecuencia[element] || 0) + 1;
  });
 const resultado= array.filter(num =>frecuencia[num] %2 ==0);
 return Array.from(new Set(resultado));
}

