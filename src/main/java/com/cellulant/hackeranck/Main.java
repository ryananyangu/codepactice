/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellulant.hackeranck;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.stream.IntStream;
//import javax.swing.text.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.jovixe.samples.Samples;
import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 *
 * @author ranyangu
 */
public class Main {

    static int formingMagicSquare(int[][] s) {
        for (int[] row : s) {
            int[] available_digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            Arrays.sort(row);
            int row_sum = row[0] + row[1] + row[2];

            if (row_sum == 15) {
                for (int i_row = 0; i_row < row.length; ++row_sum) {
                    IntStream.range(0, available_digits.length)
                            .filter(i -> i != i_row)
                            .map(i -> available_digits[i]).toArray();
                }

//                pop the values 
            } else {
//                make sure the sumation of larget and extra is less than 9
//                addition amount and pop
            }

        }
        return 1;
    }

    public static int getUmbrellas(int people, List<Integer> sizes) {
        Collections.sort(sizes);
        int len = sizes.size() - 1;
        int total_umbrellas_used = 0;
        int unallocated_people = people;

        // Part of best case
        for (int i = 0; i <= len; i++) {
            unallocated_people = people % sizes.get(len - i);
            if (unallocated_people == 0) {
                total_umbrellas_used = people / sizes.get(len - i);
                return total_umbrellas_used;
            }
        }

        // worst case
        for (int i = 0; i < len; i++) {
            unallocated_people = unallocated_people % sizes.get(len - i);
            total_umbrellas_used += unallocated_people / sizes.get(len - i);
            if (unallocated_people == 0) {
                return total_umbrellas_used;
            }
        }
        return -1;
    }

    public static List<Integer> arrayAdd(List<Integer> a, List<Integer> b) {
        int asum = 0;
        int bsum = 0;

        List<Integer> output = new LinkedList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b.get(i)) {
            } else {
                if (a.get(i) > b.get(i)) {
                    asum += 1;
                    // continue;
                } else {
                    bsum += 1;
                }

            }
        }

        output.add(asum);
        output.add(bsum);

        return output;
    }

    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long item : ar) {
            sum = Long.sum(sum, item);
        }
        return sum;
//        return ar.stream().mapToInt(Long::intValue).sum();
    }

    static String repeat(int times, String with) {
        return new String(new char[times]).replace("\0", with);
    }

    static void staircase2(int n) { // Java 10 and below
        String space = " ";
        String edge = "#";
        for (int i = 1; i <= n; i++) {
            String s_space = repeat(n - i, space);
            String s_edge = repeat(i, edge);
            System.out.println(s_space + s_edge);
        }
    }

    static void staircase(int n) { // Java 11 and above
        String space = " ";
        String edge = "#";
        for (int i = 0; i <= n; i++) {
            String s_space = space.repeat(n - i);
            String s_edge = edge.repeat(i);
            System.out.println(s_space + s_edge);
        }
    }

    static void plusMinus(int[] arr) {
        int positive_count = 0;
        int zero_count = 0;
        int negative_count = 0;

        int size = arr.length;

        for (int i : arr) {
            if (i > 0) {
                positive_count++;
            } else if (i < 0) {
                negative_count++;
            } else {
                zero_count++;
            }
        }

        System.out.println((double) positive_count / size);
        System.out.println((double) negative_count / size);
        System.out.println((double) zero_count / size);

    }

    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
//        int mini_count = 0;
        int main_count = 0;
        n -= 1;
        for (int x = 0; x < n; x++) {
            if (ar[x] == ar[x + 1]) {
                main_count++;
                x++;
            }
        }
        return main_count;
    }

    static int countingValleys(int n, String s) {
        char[] ch = s.toCharArray();

        int alt = 0;
        int valley_count = 0;
        for (char c : ch) {
            if (c == 'D') {
                alt -= 1;
                continue;
            } else {
                alt += 1;
            }

            if (alt == 0) {
                valley_count++;
            }
        }

        return valley_count;

    }

    static int birthdayCakeCandles(int[] ar) {
        Arrays.sort(ar); // get all the highest
        int size = ar.length - 1;
        int current_high = 0;
        int result = 0;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                current_high = ar[size];
                result++;
                continue; // set the first highest value to compare
            }
            if (current_high == ar[size - i]) {
                result++; // Increment the same highest occurance
            } else {
                break; // Total highest found break out of the loop
            }

        }
        return result;
    }

    static void miniMaxSum(int[] arr) {
        int size = arr.length;
        Arrays.sort(arr);

        long max_sum = 0;
        long min_sum = 0;
        for (int i = 1; i < size; i++) {
            max_sum += arr[size - i];
            min_sum += arr[i - 1];

        }
        System.out.println(min_sum + " " + max_sum);
    }

    static int jumpingOnClouds(int[] c) {

        int clouds_hoped = 0;
        for (int i = 0; i < c.length; i++) {
            if (i == 0) {
                System.out.println("Hoped on cloud : " + i);
                clouds_hoped++;
                continue;
            }
            if (c[i] == 0) {
                if (i + 2 >= c.length) {
                    continue;
                }
                if (c[i + 1] == 0 && c[i + 2] == 0) {
                    i += 2;
                    clouds_hoped++;
                    System.out.println("Hoped on cloud : " + i);
                    continue;
                }
            }

            if (c[i] == 0 && c[i + 1] == 1) {
                clouds_hoped++;
                System.out.println("Hoped on cloud : " + i);
                continue;
            }
            if (c[i] == 1 && c[i + 1] == 0) {
                i += 1;
                clouds_hoped++;
                System.out.println("Hoped on cloud : " + i);
            }

        }
        //        int[] c = {0, 0, 0, 0, 1, 0};
        //        int [] c = {0 ,0 ,1 ,0 ,0 ,1 ,0};
        //        int[] c = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0};
        //        int results = Main.jumpingOnClouds(c);
        //        System.out.println(results);

        return clouds_hoped;

    }

    static long repeatedString(String s, long n) {

        char[] sc = s.toCharArray();

        int size = sc.length;

        int a_count = 0;

        int a_sub_count = 0;

        long remainder = n % size;

        long divisible = n / size;

        if (remainder > 0) {
            char[] rem = Arrays.copyOfRange(sc, 0, (int) remainder);
//            System.out.println("Test : "+rem.toString());
            for (char ch : rem) {
                if (ch == 'a') {
                    a_sub_count++;
                }
            }
        }

        for (char c : sc) {
            if (c == 'a') {
                a_count++;
            }
        }

        long first_count = a_count * divisible;
        return first_count + a_sub_count;
    }

    public static int Solution(int[] A) {

        Arrays.sort(A);
        int len = A.length;
        if (A[len - 1] < 0) {
            return 1;
        }
        int firstvalue = A[0];
        for (int i : A) {
            if (i == firstvalue - 1) {
                continue;
            }
            if (i != firstvalue) {
                return firstvalue;
            }
            firstvalue += 1;

        }

        return firstvalue;
    }

    public static int Solution2(int n) {
        String strNo = n + "";
        String zero_string = "000000000";
        char[] number = strNo.toCharArray();
        if (number.length == 1) {
            return 0;
        }
        String result = "1" + zero_string.substring(1, number.length);
        return Integer.parseInt(result);
    }

    public static int Solution3(String s) {
//        int base_ten = Integer.parseInt(s, 2);
        long base_ten = new BigInteger(s, 2).longValue();
        int count = 0;
        while (base_ten != 0) {
            count++;
            if (base_ten % 2 == 0) {
                base_ten = base_ten / 2;
            } else {
                base_ten -= 1;
            }
        }
        return count;
    }

    public static int Solution4(int[] A) {

        HashMap<Integer, Integer> common = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (common.containsKey(A[i])) {
                Integer tmp = common.get(A[i]) + 1;
                common.put(A[i], tmp);
            } else {
                common.put(A[i], 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> it : common.entrySet()) {
            int count = it.getValue();
            ans += (count * (count - 1) / 2);

        }

        return ans;
    }

    public static void LeftRotation(int[] a, int d, int n) {
        int c, q;

        q = n % d;

        String result = "";

        if (q == 0) {
            c = n / d;
        } else {
            c = (n / d) + 1;
        }

        while (c > 0) {
            q = n % d;
//            System.out.println(q);
            System.out.println(c);
            if (q == 0) {
                n -= d;
                int[] sub = Arrays.copyOfRange(a, n, n + d);
//                int[] sub = IntStream.range(n, n+d).map(i -> a[i]).toArray();
                result += Arrays.toString(sub);
                System.out.println(result);
                n -= d;
                c--;
            } else {
                n -= q;
                int[] sub = Arrays.copyOfRange(a, n, n + q);
//                int[] sub = IntStream.range(n, n+q).map(i -> a[i]).toArray();
                result += Arrays.toString(sub);
                System.out.println(result);
                c--;
            }

        }

        System.out.println(result);

    }

    public HashMap<String, String> processMerchantResponse(String response) {

        HashMap<String, String> resp = new HashMap<>();

        // AirtelMw
        String parentTag = "COMMAND";
        String[] keys = {"MESSAGE", "TXNSTATUS", "EXTREFNUM"};
        String[] values = new String[0];
        String tag = "";
        //Mcell Moz
        // String parentTag = "member";
        //keys to extract from the payload
        // String[] keys = {"SubscriberBalanceBefore", "TUMTimeStamp", "RequestSubDealerID"};
        /*this should be empty when we don't have key value pair eg.
         <member>
         <name>SubscriberBalanceBefore</name>
         <value>    
         <string>-0.01</string>
         </value>*/
        //String[] values = {"name", "value"};
        //String tag = "";
        //Telecel Zimbambwe
        // String parentTag = "getTopupReturn";
        // String[] keys = {"ns1:agentCode", "ns24:clienttype"};
        // String[] values = new String[0];
        // String tag = "";
        //Mobipay Namibia
//        String parentTag = "PaymentResult";
//        String[] keys = {"ResponseCode", "Description"};
//        String[] values = new String[0];
//        String tag = "";
        System.out.println("processing response");

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(response));

            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName(parentTag);

            System.out.println("node length >>>>" + nodes.getLength());

            //Iterate through the tags.
            for (int i = 0; i < nodes.getLength(); i++) {
                //check if the are other members on the root tag
                Node nNode = nodes.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodes.item(i);
                    for (String key : keys) {
                        if (values.length == 0) {
                            tag = element.getElementsByTagName(key).item(0).getTextContent()
                                    == null ? " " : element.getElementsByTagName(key).item(0).getTextContent();
                        } else {
                            for (String value : values) {
                                tag = element.getElementsByTagName(value).item(0).getTextContent()
                                        == null ? " " : element.getElementsByTagName(value).item(0).getTextContent();
                            }
                        }
                        System.out.println("key >>>>" + key);
                        System.out.println("tag >>>>" + tag);
                        resp.put(key, tag);
                    }
                }
            }

            System.out.println("response is " + resp.toString());

        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
            String msg = e.getCause() == null ? e.getCause().toString()
                    : " " + "exception caught : " + e.getMessage();
            System.out.println("exception caught " + e.getMessage());
        }
        return resp;
    }

    public static void main(String[] args) {

//        String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:epar=\"http://sclinsmsvm01p/wsdls/Surfline/EpartnerDataPurchase.wsdl\">\n" +
//"  <soapenv:Header/>\n" +
//"  <soapenv:Body>\n" +
//"     <epar:EpartnerDataPurchaseRequest>\n" +
//"        <CC_Calling_Party_Id>539381234812</CC_Calling_Party_Id>\n" +
//"        <CHANNEL>Cellulant</CHANNEL>\n" +
//"        <TRANSACTION_ID>12362744</TRANSACTION_ID>\n" +
//"        <Recipient_Number>233255000102</Recipient_Number>\n" +
//"        <RECEPIENT_WALLET_TYPE>Primary</RECEPIENT_WALLET_TYPE>\n" +
//"        <AMOUNT>1.5gbp</AMOUNT>\n" +
//"        <Request_type>Data</Request_type>\n" +
//"     </epar:EpartnerDataPurchaseRequest>\n" +
//"  </soapenv:Body>\n" +
//"</soapenv:Envelope>";
//        
//        HashMap<String,String> headers = new HashMap<>();
//        headers.put("Accept-Encoding", "gzip,deflate"); //(3);
//        headers.put("Content-Type", "text/xml;charset=UTF-8");
//        headers.put("Content-length", "394");
//        headers.put("Connection", "Keep-Alive");
//        headers.put("Host", "172.25.38.43:2222");
//        headers.put("User-Agent","Apache-HttpClient/4.1.1 (java 1.5)");
//        headers.put("Authorization","Basic cellulant:cellulant1234");
//        
//        String url = "http://3.122.24.11:9000/surfline/";
//        
//        
//        System.out.println(Samples.updatedPostMethod(url, payload, headers).toString());
//        int[] a1 = {1, 3, 6, 4, 1, 2};
//        int[] a2 = {1, 2, 3};
//        int[] a3 = {-1, -3};
//        int x = 1000570070;
//        String y = "";
//        int[] A = {3, 5, 6, 3, 3, 5, 6, 6, 3};
        int[] a = {1, 2, 3, 4, 5};
        int n = 5;
        int d = 2;
        Main.LeftRotation(a, d, n);

    }
}
