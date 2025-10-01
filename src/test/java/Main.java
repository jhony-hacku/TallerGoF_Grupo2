public class Main {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("¡Hola desde Docker!");
        System.out.println("=================================");
        
        // Ejemplo de cálculos simples
        Calculadora calc = new Calculadora();
        
        System.out.println("\n--- Probando Calculadora ---");
        System.out.println("5 + 3 = " + calc.sumar(5, 3));
        System.out.println("10 - 4 = " + calc.restar(10, 4));
        System.out.println("6 * 7 = " + calc.multiplicar(6, 7));
        System.out.println("20 / 4 = " + calc.dividir(20, 4));
        
        // Ejemplo con lista
        System.out.println("\n--- Lista de lenguajes ---");
        String[] lenguajes = {"Java", "Python", "JavaScript", "C++", "Go"};
        for (int i = 0; i < lenguajes.length; i++) {
            System.out.println((i + 1) + ". " + lenguajes[i]);
        }
        
        System.out.println("\n¡Aplicación ejecutada exitosamente en Docker!");
    }
}

class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public int restar(int a, int b) {
        return a - b;
    }
    
    public int multiplicar(int a, int b) {
        return a * b;
    }
    
    public double dividir(int a, int b) {
        if (b == 0) {
            System.out.println("Error: No se puede dividir por cero");
            return 0;
        }
        return (double) a / b;
    }
}
