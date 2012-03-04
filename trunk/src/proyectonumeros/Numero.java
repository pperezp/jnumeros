/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectonumeros;

/**
 *
 * @author Patricio Pérez Pinto
 */
public class Numero {
    public static String getNumeroAsString(int numero){
        if(numero < 10){
            return getNumeroDel_l_Al_9(numero, false);
        }else if(numero < 100){
            return getNumeroDel_10_al_99(numero, false);
        }else if(numero < 1000){
            return getNumeroDel_100_Al_999(numero, false);
        }else if(numero < 10000){
            String num = String.valueOf(numero);
            String n1 = num.substring(0, 1);
            String n2 = num.substring(1);

            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            
            return getNumeroDel_l_Al_9(num1, true) + " mil "+ getNumeroDel_100_Al_999(num2, false);
        }else if(numero < 100000){
            String num = String.valueOf(numero);
            String n1 = num.substring(0, 2);
            String n2 = num.substring(2);

            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            
            return getNumeroDel_10_al_99(num1, true) + " mil "+ getNumeroDel_100_Al_999(num2, false);
        }else if(numero < 1000000){
            String num = String.valueOf(numero);
            String n1 = num.substring(0, 3);
            String n2 = num.substring(3);

            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            
            return getNumeroDel_100_Al_999(num1, true) + " mil "+ getNumeroDel_100_Al_999(num2, false);
        }else if(numero < 10000000){
            String num = String.valueOf(numero);
            String n1 = num.substring(0, 1);
            String n2 = num.substring(1, 4);
            String n3 = num.substring(4);

            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            int num3 = Integer.parseInt(n3);
            
            return getNumeroDel_l_Al_9(num1, true) + (num1 == 1 ?" millon ":" millones ")+ getNumeroDel_100_Al_999(num2, true) + (num2 == 0 ?"":" mil ") + getNumeroDel_100_Al_999(num3, false);
        }else if(numero < 100000000){
            String num = String.valueOf(numero);
            String n1 = num.substring(0, 2);
            String n2 = num.substring(2, 5);
            String n3 = num.substring(5);

            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            int num3 = Integer.parseInt(n3);
            
            return getNumeroDel_10_al_99(num1, true) + " millones "+ getNumeroDel_100_Al_999(num2, true) + (num2 == 0 ?"":" mil ") + getNumeroDel_100_Al_999(num3, false);
        }else if(numero < 1000000000){
            String num = String.valueOf(numero);
            String n1 = num.substring(0, 3);
            String n2 = num.substring(3, 6);
            String n3 = num.substring(6);

            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            int num3 = Integer.parseInt(n3);
            
            return getNumeroDel_100_Al_999(num1, true) + " millones "+ getNumeroDel_100_Al_999(num2, true) + (num2 == 0 ?"":" mil ") + getNumeroDel_100_Al_999(num3, false);
        }
       return null;
    }
    
    private static String getNumeroDel_l_Al_9(int numero, boolean isMil){
        switch(numero){
            case 1:{
                return isMil ? "un" : "uno";
            }
            case 2:{
                return "dos";
            }
            case 3:{
                return "tres";
            }
            case 4:{
                return "cuatro";
            }
            case 5:{
                return "cinco";
            }
            case 6:{
                return "seis";
            }
            case 7:{
                return "siete";
            }
            case 8:{
                return "ocho";
            }
            case 9:{
                return "nueve";
            }
        }
        return "";
    }
    
    private static String getNumeroDel_10_al_99(int numero, boolean isMil){
        if(numero < 10){
            return getNumeroDel_l_Al_9(numero, isMil);
        }else{
        //SEPARO EL NÚMERO
        //EJEMPLO: SI FUERA 21, SERIA 2 Y 1
        char num1 = Integer.toString(numero).charAt(0);
        char num2 = Integer.toString(numero).charAt(1);

        //LOS GUARDO EN INT
        int n1 = Integer.parseInt(Character.toString(num1));
        int n2 = Integer.parseInt(Character.toString(num2));
        
        if(numero > 10 && numero < 16){//ENTRE 11 Y 15
            switch(numero){
                case 11:{
                    return "once";
                }
                case 12:{
                    return "doce";
                }
                case 13:{
                    return "trece";
                }
                case 14:{
                    return "catorce";
                }
                case 15:{
                    return "quince";
                }
                default:{
                    return "";
                }
            }
        }else if(n2 != 0){//SI N2 != 0, ES PORQUE NO ES UN NUMERO CON 0 AL FINAL, COMO 20
            return getNumerosMenoresQue100SinCeros(n1)+getNumeroDel_l_Al_9(n2, isMil);
        }else{
            return getNumerosMenoresQue100ConCeros(n1);
        }}
    }
    
    private static String getNumeroDel_100_Al_999(int numero, boolean isMil){
        if(numero < 100){
            return getNumeroDel_10_al_99(numero, isMil);
        }else{
        //ACA SEPARO EL NUMERO ASI
        //254 = N1 = 2, N2 = 54
        String num = String.valueOf(numero);
        String n1 = num.substring(0, 1);
        String n2 = num.substring(1);
        
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        
        if(numero == 100){//UNICA REGLA DISTINTA
            return "cien";
        }else if(num2 != 0){//
            if(num2 > 0 && num2 < 10){
                return getNumerosMenoresQue1000(num1) + " " +getNumeroDel_l_Al_9(num2, isMil);
            }else{
                return getNumerosMenoresQue1000(num1) + " " +getNumeroDel_10_al_99(num2, isMil);
            }
        }else{
            return getNumerosMenoresQue1000(num1);
        }}
    }
    
    private static String getNumerosMenoresQue100SinCeros(int numero){
        switch(numero){
            case 1:{
                return "dieci";
            }
            case 2:{
                return "veinti";
            }
            case 3:{
                return "treinta y ";
            }
            case 4:{
                return "cuarenta y ";
            }
            case 5:{
                return "cincuenta y ";
            }
            case 6:{
                return "sesenta y ";
            }
            case 7:{
                return "setenta y ";
            }
            case 8:{
                return "ochenta y ";
            }
            case 9:{
                return "noventa y ";
            }
        }
        return null;
    }
    
    private static String getNumerosMenoresQue100ConCeros(int numero){
        switch(numero){
            case 1:{
                return "diez";
            }
            case 2:{
                return "veinte";
            }
            case 3:{
                return "treinta";
            }
            case 4:{
                return "cuarenta";
            }
            case 5:{
                return "cincuenta";
            }
            case 6:{
                return "sesenta";
            }
            case 7:{
                return "setenta";
            }
            case 8:{
                return "ochenta";
            }
            case 9:{
                return "noventa";
            }
        }
        return null;
    }
    
    private static String getNumerosMenoresQue1000(int numero){
        switch(numero){
            case 1:{
                return "ciento";
            }
            case 2:{
                return "docientos";
            }
            case 3:{
                return "trecientos";
            }
            case 4:{
                return "cuatrocientos";
            }
            case 5:{
                return "quinientos";
            }
            case 6:{
                return "seiscientos";
            }
            case 7:{
                return "setencientos";
            }
            case 8:{
                return "ochocientos";
            }
            case 9:{
                return "novecientos";
            }
        }
        return null;
    }
}
