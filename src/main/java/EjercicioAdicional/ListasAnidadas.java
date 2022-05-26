package EjercicioAdicional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListasAnidadas {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        List<List<Integer>> f = new ArrayList<>();
        f.add(a);
        f.add(b);
        List<List<List<Integer>>> d = new ArrayList<>();
        d.add(f);
        d.add(f);
        System.out.println(d);

        //List<Object> z = d.stream().flatMap(letra -> letra.stream()).map(letra-> letra).flatMap(letra -> letra.stream());

        List<Integer> out = new ArrayList<>();

        //profe basandome en la respuesta que Ud nos paso, logre con  solo foreach imprimirlo, pero como se que no era la idea la dejo comentada.
        //d.forEach(e -> e.forEach(j -> j.forEach(k -> out.add(k))));


        //en esta linea, sin hacer uso del flatmap, para no hacer lo mismo que otros hicieron, despues de mucho investigar,
        //logre llegar con los map a cada uno de los niveles y al final guardarlo en una nueva lista. Se que no es el escenario ideal pero queria mostrar
        //algo que obtuviera el mismo resultado pero con un metodo diferente.
        d.stream().map(e -> e.stream().map(k -> k.stream().peek(m -> out.add(m)).collect(Collectors.toList())).collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(out);
    }
}
