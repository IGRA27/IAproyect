package redesneuronales;

public class FE {
//ISAAC REYES
    public static String[] formEncoding(String[] features) {
        String formString = features[6];
        int formNumber = 0;

        if ("standard".equals(formString.toLowerCase())) {
            formNumber = 0;
        } else if("legacy".equals(formString.toLowerCase())) {
            formNumber = 1;
        } else if("historic".equals(formString.toLowerCase())) {
            formNumber = 2;
        } else if("modern".equals(formString.toLowerCase())) {
            formNumber = 3;
        } else if("free-form".equals(formString.toLowerCase())) {
            formNumber = 4;
        } else if("pioneer".equals(formString.toLowerCase())) {
            formNumber = 5;
        } else if("vintage".equals(formString.toLowerCase())) {
            formNumber = 6;
        } else if("old school".equals(formString.toLowerCase())) {
            formNumber = 7;
        } else if("premodern".equals(formString.toLowerCase())) {
            formNumber = 8;
        } else if("pauper".equals(formString.toLowerCase())) {
            formNumber = 9;
        } else if("standard 2022".equals(formString.toLowerCase())) {
            formNumber = 10;
        } else if("alchemy".equals(formString.toLowerCase())) {
            formNumber = 11;
        } else if("explorer".equals(formString.toLowerCase())) {
            formNumber = 12;
        } else if("limited".equals(formString.toLowerCase())) {
            formNumber = 13;
        }

        features[12] = String.valueOf(formNumber);

        return features;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
