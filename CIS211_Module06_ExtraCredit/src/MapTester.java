import java.util.Scanner;

class MapTester {
    public static void main(String[] args) {

        String[][] data = {
                // ===== Country → Capital (32) =====
                {"United States", "Washington, D.C."},
                {"Canada", "Ottawa"},
                {"Mexico", "Mexico City"},
                {"Brazil", "Brasília"},
                {"Argentina", "Buenos Aires"},
                {"United Kingdom", "London"},
                {"France", "Paris"},
                {"Germany", "Berlin"},
                {"Spain", "Madrid"},
                {"Italy", "Rome"},
                {"Portugal", "Lisbon"},
                {"Netherlands", "Amsterdam"},
                {"Belgium", "Brussels"},
                {"Switzerland", "Bern"},
                {"Austria", "Vienna"},
                {"Sweden", "Stockholm"},
                {"Norway", "Oslo"},
                {"Denmark", "Copenhagen"},
                {"Finland", "Helsinki"},
                {"Poland", "Warsaw"},
                {"Czech Republic", "Prague"},
                {"Hungary", "Budapest"},
                {"Greece", "Athens"},
                {"Turkey", "Ankara"},
                {"Russia", "Moscow"},
                {"India", "New Delhi"},
                {"China", "Beijing"},
                {"Japan", "Tokyo"},
                {"South Korea", "Seoul"},
                {"Australia", "Canberra"},
                {"New Zealand", "Wellington"},
                {"Egypt", "Cairo"},
                {"Saudi Arabia", "Riyadh"},

                // ===== Animal → Class/Type (20) =====
                {"Dog", "Mammal"},
                {"Cat", "Mammal"},
                {"Eagle", "Bird"},
                {"Salmon", "Fish"},
                {"Frog", "Amphibian"},
                {"Crocodile", "Reptile"},
                {"Butterfly", "Insect"},
                {"Spider", "Arachnid"},
                {"Dolphin", "Mammal"},
                {"Penguin", "Bird"},
                {"Shark", "Fish"},
                {"Toad", "Amphibian"},
                {"Lizard", "Reptile"},
                {"Bee", "Insect"},
                {"Octopus", "Cephalopod"},
                {"Snail", "Mollusk"},
                {"Ant", "Insect"},
                {"Owl", "Bird"},
                {"Whale", "Mammal"},
                {"Bat", "Mammal"},

                // ===== Fruit → Typical Color (20) =====
                {"Apple", "Red"},
                {"Banana", "Yellow"},
                {"Grape", "Purple"},
                {"Orange", "Orange"},
                {"Lemon", "Yellow"},
                {"Lime", "Green"},
                {"Blueberry", "Blue"},
                {"Strawberry", "Red"},
                {"Watermelon", "Green"},
                {"Cherry", "Red"},
                {"Peach", "Orange"},
                {"Pear", "Green"},
                {"Plum", "Purple"},
                {"Mango", "Orange"},
                {"Kiwi", "Green"},
                {"Raspberry", "Red"},
                {"Blackberry", "Black"},
                {"Grapefruit", "Pink"},
                {"Papaya", "Orange"},
                {"Cantaloupe", "Orange"},

                // ===== Language → Family (16) =====
                {"English", "Germanic"},
                {"German", "Germanic"},
                {"Dutch", "Germanic"},
                {"Spanish", "Romance"},
                {"French", "Romance"},
                {"Italian", "Romance"},
                {"Portuguese", "Romance"},
                {"Romanian", "Romance"},
                {"Russian", "Slavic"},
                {"Polish", "Slavic"},
                {"Czech", "Slavic"},
                {"Ukrainian", "Slavic"},
                {"Hindi", "Indo-Aryan"},
                {"Bengali", "Indo-Aryan"},
                {"Arabic", "Semitic"},
                {"Hebrew", "Semitic"},
                {"Turkish", "Turkic"},
                {"Mandarin", "Sinitic"},
                {"Japanese", "Japonic"},
                {"Korean", "Koreanic"},

                // ===== File Extension → Type (25) =====
                {".txt", "Plain Text"},
                {".md", "Markdown"},
                {".pdf", "Document"},
                {".docx", "Word Document"},
                {".xlsx", "Excel Spreadsheet"},
                {".pptx", "PowerPoint Presentation"},
                {".csv", "Comma-Separated Values"},
                {".json", "JSON Data"},
                {".xml", "XML Data"},
                {".html", "HTML Document"},
                {".css", "Stylesheet"},
                {".js", "JavaScript"},
                {".ts", "TypeScript"},
                {".java", "Java Source"},
                {".py", "Python Script"},
                {".c", "C Source"},
                {".cpp", "C++ Source"},
                {".rb", "Ruby Script"},
                {".php", "PHP Script"},
                {".sh", "Shell Script"},
                {".jpg", "Image"},
                {".png", "Image"},
                {".gif", "Image"},
                {".mp3", "Audio"},
                {".wav", "Audio"},
                {".mp4", "Video"},
                {".mov", "Video"},
                {".zip", "Archive"},
                {".rar", "Archive"},
                {".7z", "Archive"},

                // ===== Planet → Orbit Order (8) =====
                {"Mercury", "First"},
                {"Venus", "Second"},
                {"Earth", "Third"},
                {"Mars", "Fourth"},
                {"Jupiter", "Fifth"},
                {"Saturn", "Sixth"},
                {"Uranus", "Seventh"},
                {"Neptune", "Eighth"},

                // ===== Sport → Primary Equipment (15) =====
                {"Soccer", "Ball"},
                {"Basketball", "Ball"},
                {"Tennis", "Racket"},
                {"Baseball", "Bat"},
                {"Golf", "Club"},
                {"Hockey", "Stick"},
                {"Cricket", "Bat"},
                {"Boxing", "Gloves"},
                {"Table Tennis", "Paddle"},
                {"Badminton", "Racket"},
                {"Volleyball", "Ball"},
                {"American Football", "Ball"},
                {"Swimming", "Goggles"},
                {"Archery", "Bow"},
                {"Skiing", "Skis"},

                // ===== Company → Notable Product/Brand (15) =====
                {"Microsoft", "Windows"},
                {"Apple", "iPhone"},
                {"Google", "Search"},
                {"Amazon", "Prime"},
                {"Meta", "Facebook"},
                {"Tesla", "Model S"},
                {"Samsung", "Galaxy"},
                {"Sony", "PlayStation"},
                {"Nintendo", "Switch"},
                {"Adobe", "Photoshop"},
                {"Intel", "Core"},
                {"NVIDIA", "GeForce"},
                {"IBM", "Watson"},
                {"Oracle", "Database"},
                {"Salesforce", "CRM"},

                // ===== Food → Category (10) =====
                {"Bread", "Grain"},
                {"Chicken", "Poultry"},
                {"Beef", "Red Meat"},
                {"Salmon", "Seafood"},
                {"Tofu", "Protein"},
                {"Rice", "Grain"},
                {"Broccoli", "Vegetable"},
                {"Carrot", "Vegetable"},
                {"Milk", "Dairy"},
                {"Yogurt", "Dairy"},

                // ===== Geographic Feature → Type (10) =====
                {"Nile", "River"},
                {"Sahara", "Desert"},
                {"Everest", "Mountain"},
                {"Amazon", "Rainforest"},
                {"Pacific", "Ocean"},
                {"Danube", "River"},
                {"Gobi", "Desert"},
                {"Alps", "Mountains"},
                {"Andes", "Mountains"},
                {"Mississippi", "River"},

                // ===== Math Concept → Field (10) =====
                {"Derivative", "Calculus"},
                {"Integral", "Calculus"},
                {"Limit", "Calculus"},
                {"Matrix", "Linear Algebra"},
                {"Vector", "Linear Algebra"},
                {"Prime", "Number Theory"},
                {"Graph", "Discrete Math"},
                {"Logarithm", "Algebra"},
                {"Probability", "Statistics"},
                {"Permutation", "Combinatorics"},

                // ===== Programming Concept → Category (10) =====
                {"Stack", "Data Structure"},
                {"Queue", "Data Structure"},
                {"Binary Tree", "Data Structure"},
                {"HashMap", "Data Structure"},
                {"Recursion", "Algorithm"},
                {"Sorting", "Algorithm"},
                {"Polymorphism", "OOP"},
                {"Inheritance", "OOP"},
                {"Encapsulation", "OOP"},
                {"Regex", "Pattern Matching"},

                // ===== Artist → Movement/Style (9) =====
                {"Monet", "Impressionism"},
                {"Picasso", "Cubism"},
                {"Van Gogh", "Post-Impressionism"},
                {"Leonardo da Vinci", "Renaissance"},
                {"Michelangelo", "Renaissance"},
                {"Rembrandt", "Baroque"},
                {"Dalí", "Surrealism"},
                {"Matisse", "Fauvism"},
                {"Warhol", "Pop Art"}
        };

        MyMap<String, String> dictionary = new MyMap<>(2000);
        for (String[] each: data) {dictionary.insert(each[0], each[1]);}

        //MyMap<String, String> dictionary = new MyMap<>(1000);
//        dictionary.insert("Computer", "Magic Black Box");       // 'C' = 67
//        dictionary.insert("Phone", "Evil Black Box");           // 'P' = 80
//        dictionary.insert("Monitor", "Flat Black Box");         // 'M' = 77
//        dictionary.insert("DTCC", "Best School in Wilmington"); // 'D' = 68
//
//        System.out.println("DTCC is defined as: " + dictionary.get("DTCC"));

        System.out.println("This dictionary has: " + dictionary.getCollisions() + " collisions");

        Scanner keyboard = new Scanner(System.in);
        while (true)
        {
            System.out.println("Enter a word: ");
            String word = keyboard.next();
            System.out.println(word + " defined as " + dictionary.get(word));
        }
    }
}