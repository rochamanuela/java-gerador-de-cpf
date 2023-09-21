import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // importando o Scanner
        Scanner tec = new Scanner(System.in);

        // solicitando o CPF para o usuário
        System.out.print("\n\nDigite o CPF (somente os 9 primeiros dígitos): ");
        String entradaCPF = tec.nextLine();
        tec.close();

        // tratando a entrada do teclado
        String caracteresCPF;
        caracteresCPF = entradaCPF.replace(".", ""); // removendo os pontos
        caracteresCPF = caracteresCPF.replace("-", ""); // removendo os hífens

        // fatiando o CPF por caracter
        String[] stringsCPF;
        stringsCPF = caracteresCPF.split("");

        // criando os arrays para guardar os números
        int[] numerosCPF = new int[stringsCPF.length];
        int[] cpf = new int[caracteresCPF.length()];

        // convertendo os caracteres em números e armazenando
        for (int i = 0; i < numerosCPF.length; i++) {
            cpf[i] = Integer.parseInt(stringsCPF[i]);
        }

        // iniciando as verificações
        int verificacao;
        int contador = 10;
        int soma1 = 0;

        for(int dig: cpf){
            verificacao = dig * contador;
            contador--;
            soma1 = soma1 + verificacao;
        }

        int d1 = 11 - (soma1 % 11);
        if (d1 > 9){
            d1 = 0;
        }

        int contador2 = 11;
        int soma2 = 0;

        for(int dig: cpf){
            verificacao = dig * contador2;
            contador2--;
            soma2 = soma2 + verificacao;
        }
        soma2 = soma2 + d1 * 2;

        int d2 = 11 - (soma2 % 11);
        if (d2 > 9){
            d2 = 0;
        }

        int cont = 0;
        int contGlobal = 0;

        System.out.print("Resultado ---> ");
        for(int dig: cpf) {
            System.out.print(dig);
            cont++;
            contGlobal++;
            if (cont == 3 && contGlobal != 9) {
                System.out.print(".");
                cont = 0;
            }
        }

        System.out.print("-" + d1 + d2 + "\n\n");
    }
}
