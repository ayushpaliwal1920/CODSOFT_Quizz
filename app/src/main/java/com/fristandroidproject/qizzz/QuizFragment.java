package com.fristandroidproject.qizzz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.fragment.app.Fragment;

import com.fristandroidproject.qizzz.databinding.FragmentQuizBinding;
import com.fristandroidproject.qizzz.modelclass.QuizzzModel;

import java.util.ArrayList;
import java.util.Objects;


public class QuizFragment extends Fragment {

 FragmentQuizBinding binding;
 ArrayList<QuizzzModel> quizList = new ArrayList<>();
 private int position = 0;
 int correct = 0;
 private String answer = null;
 int totalQues;
 String listSize;
 String positionNo;
 QuizzzModel quizzzModel;
 String category , titleSub;
 Toolbar toolbar;

 String quizListSize;
    public QuizFragment() {

    }
    public QuizFragment(String category,String titleSub) {
       this.category = category;
       this.titleSub = titleSub;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuizBinding.inflate(getLayoutInflater());
        loadQizz();
        EnableOption();
        clearOptn();
        binding.btnNext.setOnClickListener(v->{
            position++;
            loadQizz();
            EnableOption();
            clearOptn();
            checkNextQ();
//            binding.questionNumber.setText(position);
        });

        return binding.getRoot();
    }

    private void checkNextQ() {
        if (position == totalQues){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapContainer,new ResultFragment(correct,totalQues,category,titleSub)).commit();
            quizList.clear();
            position = 0;
        }
    }

    private void clearOptn() {
        binding.option1.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option1.setTextColor(getContext().getColor(R.color.black));
        binding.option2.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option2.setTextColor(getContext().getColor(R.color.black));
        binding.option3.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option3.setTextColor(getContext().getColor(R.color.black));
        binding.option4.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option4.setTextColor(getContext().getColor(R.color.black));
        binding.btnNext.setBackgroundResource(R.drawable.btn_primary);
    }

    private void EnableOption() {
        binding.option1.setEnabled(true);
        binding.option2.setEnabled(true);
        binding.option3.setEnabled(true);
        binding.option4.setEnabled(true);
        binding.btnNext.setEnabled(false);
    }

    @SuppressLint("SetTextI18n")
    private void loadQizz() {// for questions and ans

        switch (titleSub) {

            // Science
            case "Physics":
                quizList.add(new QuizzzModel("First law", "Zeroth law", "First law", "Second law", "Third law", "Which law of thermodynamics states that energy can neither be created nor destroyed?"));
                quizList.add(new QuizzzModel("Onnes", "Onnes", "Fermi", "Planck", "Heisenberg", "The phenomenon of superconductivity was discovered by?"));
                quizList.add(new QuizzzModel("11.2 km/s", "7.9 km/s", "9.8 km/s", "11.2 km/s", "12.5 km/s", "The escape velocity on Earth is approximately:"));
                quizList.add(new QuizzzModel("Davisson–Germer", "Rutherford’s scattering", "Michelson–Morley", "Davisson–Germer", "Millikan oil drop", "The dual nature of light was proved by which experiment?"));
                quizList.add(new QuizzzModel("Strong nuclear", "Gravitational", "Weak nuclear", "Electromagnetic", "Strong nuclear", "Which fundamental force is the strongest in nature?"));
                quizList.add(new QuizzzModel("Weber", "Tesla", "Weber", "Gauss", "Newton", "The unit of magnetic flux is:"));
                quizList.add(new QuizzzModel("h/mv", "h/mv", "mv/h", "hv/m", "h²/mv", "What is the de Broglie wavelength of an electron moving with velocity v?"));
                quizList.add(new QuizzzModel("Photon", "Proton", "Photon", "Neutron", "Electron", "Which particle has zero rest mass?"));
                quizList.add(new QuizzzModel("Length", "Mass", "Length", "Amplitude", "Both mass & length", "The time period of a simple pendulum depends on:"));
                quizList.add(new QuizzzModel("Bernoulli’s principle", "Bernoulli’s principle", "Newton’s first law", "Pascal’s law", "Boyle’s law", "Which law explains why aeroplanes can fly?"));
                setUp();
                break;

            case "Chemistry":
                quizList.add(new QuizzzModel("Fluorine", "Oxygen", "Nitrogen", "Chlorine", "Fluorine", "Which element has the highest electronegativity?"));
                quizList.add(new QuizzzModel("7", "0", "7", "14", "10", "The pH of a neutral solution at 25°C is:"));
                quizList.add(new QuizzzModel("Hydrogen", "Oxygen", "Hydrogen", "Chlorine", "Nitrogen", "Which gas is liberated during the electrolysis of water at"));
                quizList.add(new QuizzzModel("Aluminium", "Copper", "Aluminium", "Zinc", "Iron", "Which metal is extracted by the Hall-Héroult process?"));
                quizList.add(new QuizzzModel("Tetrahedral", "Square planar", "Tetrahedral", "Trigonal planar", "Linear", "The molecular geometry of methane (CH₄) is:"));
                quizList.add(new QuizzzModel("Sulphuric acid", "Nitric acid", "Hydrochloric acid", "Sulphuric acid", "Acetic acid", "Which acid is called “oil of vitriol”?"));
                quizList.add(new QuizzzModel("Number of molecules in 1 mole", "Number of protons in 1 g H", "Number of molecules in 1 mole", "Number of atoms in 1 g O₂", "Number of ions in 1 L water", "Avogadro’s number represents:"));
                quizList.add(new QuizzzModel("Triple covalent", "Ionic", "Hydrogen", "Covalent", "Triple covalent", "Which type of bond is strongest?"));
                quizList.add(new QuizzzModel("NaHCO₃", "Na₂CO₃", "NaHCO₃", "K₂CO₃", "CaCO₃", "Which compound is known as “baking soda”?"));
                quizList.add(new QuizzzModel("Americium", "Uranium", "Plutonium", "Americium", "Radium", "Which radioactive element is used in smoke detectors?"));
                setUp();
                break;

            case "Biology":
                quizList.add(new QuizzzModel("Nephron", "Nephron", "Alveoli", "Neuron", "Glomerulus", "The functional unit of the kidney is:"));
                quizList.add(new QuizzzModel("Mendel", "Darwin", "Mendel", "Lamarck", "Watson", "Who is called the “Father of Genetics”?"));
                quizList.add(new QuizzzModel("Chloroplast", "Mitochondria", "Chloroplast", "Ribosome", "Nucleus", "Photosynthesis occurs in which cell organelle?"));
                quizList.add(new QuizzzModel("O–", "A+", "B+", "O–", "AB+", "Which blood group is known as universal donor?"));
                quizList.add(new QuizzzModel("Vitamin D", "Vitamin A", "Vitamin D", "Vitamin C", "Vitamin K", "Which vitamin is produced in the skin by sunlight?"));
                quizList.add(new QuizzzModel("Pancreas", "Liver", "Pancreas", "Kidney", "Stomach", "Insulin is secreted by which organ?"));
                quizList.add(new QuizzzModel("Cerebellum", "Cerebrum", "Cerebellum", "Medulla", "Thalamus", "Which part of the brain controls balance and coordination?"));
                quizList.add(new QuizzzModel("Auxin", "Cytokinin", "Auxin", "Gibberellin", "Ethylene", "Which plant hormone promotes cell elongation?"));
                quizList.add(new QuizzzModel("Cell", "Organ", "Cell", "Tissue", "Atom", "The smallest unit of life is:"));
                quizList.add(new QuizzzModel("optn4", "Housefly", "Female Anopheles mosquito", "Male Culex mosquito", "Tsetse fly", "Which organism is the vector of malaria?"));
                setUp();
                break;

            case "Astronomy":
                quizList.add(new QuizzzModel("Event Horizon", "Event Horizon", "Singularity", "Photon Sphere", "Accretion Disk", "What is the boundary beyond which nothing can escape from a black hole called?"));
                quizList.add(new QuizzzModel("Hertzsprung-Russell Diagram", "Periodic Table", "Hertzsprung-Russell Diagram", "Doppler Spectrum", "Redshift Graph", "Which diagram classifies stars based on luminosity and temperature?"));
                quizList.add(new QuizzzModel("Ceres", "Ceres", "Vesta", "Eris", "Haumea", "What is the largest object in the asteroid belt?"));
                quizList.add(new QuizzzModel("Cosmic Microwave Background", "Solar Wind", "Dark Matter", "Cosmic Microwave Background", "Gamma Ray Burst", "What radiation is the remnant of the Big Bang?"));
                quizList.add(new QuizzzModel("Jupiter", "Mars", "Jupiter", "Saturn", "Neptune", "Which planet has the shortest day (fastest rotation) in our solar system?"));
                quizList.add(new QuizzzModel("Kepler’s Laws", "Newton’s Laws", "Kepler’s Laws", "Ohm’s Laws", "Archimedes’ Principle", "Which laws describe planetary motion around the Sun?"));
                quizList.add(new QuizzzModel("Hydrogen & Helium", "Oxygen & Carbon", "Hydrogen & Helium", "Iron & Nickel", "Silicon & Magnesium", "What are the two most abundant elements in stars?"));
                quizList.add(new QuizzzModel("Neutron Star", "White Dwarf", "Neutron Star", "Red Giant", "Brown Dwarf", "What is the extremely dense remnant of a massive star after a supernova called?"));
                quizList.add(new QuizzzModel("Redshift", "Blueshift", "Redshift", "Spectroscopy", "Photon Drift", "What phenomenon shows that the universe is expanding?"));
                quizList.add(new QuizzzModel("Saturn", "Uranus", "Saturn", "Jupiter", "Neptune", "Which planet has the most prominent and complex ring system in the solar system?"));
                setUp();
                break;



            case "Environmental Science":
                quizList.add(new QuizzzModel("Carbon Dioxide", "Oxygen", "Carbon Dioxide", "Methane", "Nitrogen", "Which gas is the primary contributor to global warming?"));
                quizList.add(new QuizzzModel("Kyoto Protocol", "Paris Agreement", "Montreal Protocol", "Kyoto Protocol", "Geneva Convention", "Which international treaty was the first to set binding obligations on greenhouse gas emissions?"));
                quizList.add(new QuizzzModel("Amazon Rainforest", "Congo Rainforest", "Amazon Rainforest", "Daintree Rainforest", "Sundarbans", "Which forest is often referred to as the 'lungs of the Earth'?"));
                quizList.add(new QuizzzModel("Chlorofluorocarbons (CFCs)", "Carbon Monoxide", "Chlorofluorocarbons (CFCs)", "Sulfur Dioxide", "Methane", "Which chemical compounds are primarily responsible for ozone layer depletion?"));
                quizList.add(new QuizzzModel("Eutrophication", "Deforestation", "Acid Rain", "Eutrophication", "Desertification", "What is the process called when excessive nutrients in water bodies cause algal blooms?"));
                quizList.add(new QuizzzModel("Ramsar Convention", "Rio Declaration", "Ramsar Convention", "CITES", "Stockholm Convention", "Which international treaty is focused on the conservation of wetlands?"));
                quizList.add(new QuizzzModel("India", "Brazil", "USA", "India", "Australia", "Which country launched the International Solar Alliance (ISA) in 2015?"));
                quizList.add(new QuizzzModel("Sulfur Dioxide & Nitrogen Oxides", "Carbon Dioxide & Methane", "Ozone & VOCs", "Sulfur Dioxide & Nitrogen Oxides", "Ammonia & Lead", "Which pollutants are mainly responsible for acid rain?"));
                quizList.add(new QuizzzModel("Silent Spring", "The Inconvenient Truth", "Our Common Future", "Silent Spring", "The Climate Book", "Which 1962 book by Rachel Carson raised global awareness about pesticides’ impact on the environment?"));
                quizList.add(new QuizzzModel("UNEP (United Nations Environment Programme)", "UNESCO", "UNEP (United Nations Environment Programme)", "WHO", "FAO", "Which UN agency is responsible for coordinating global environmental activities?"));
                setUp();
                break;



                // math

            case "Algebra":
                quizList.add(new QuizzzModel("x = -2", "x = 2", "x = -2", "x = 4", "No solution", "Solve for x: 2x + 4 = 0"));
                quizList.add(new QuizzzModel("49", "36", "49", "25", "64", "What is (2x + 3)² when x = 2?"));
                quizList.add(new QuizzzModel("x = 3", "x = 5", "x = 3", "x = -3", "x = 0", "Solve: x² - 9 = 0"));
                quizList.add(new QuizzzModel("2x - 7", "2x + 7", "2x - 7", "x - 7", "x² - 7", "Factorize: (x + 2)(2x - 7) ÷ (x + 2)"));
                quizList.add(new QuizzzModel("81", "64", "100", "81", "49", "Simplify: (3x)² when x = 3"));
                quizList.add(new QuizzzModel("5/2", "5/2", "2/5", "10", "1/10", "If 2x = 5, what is x?"));
                quizList.add(new QuizzzModel("x = 1 or x = -4", "x = -1", "x = 1 or x = -4", "x = 2", "x = 4", "Solve: x² + 3x - 4 = 0"));
                quizList.add(new QuizzzModel("x = 7", "x = 7", "x = -7", "x = 0", "x = 2", "If 2x - 5 = 9, find x."));
                quizList.add(new QuizzzModel("x = 1/3", "x = 3", "x = 1/3", "x = 0", "x = -3", "Solve: 3x = 1"));
                quizList.add(new QuizzzModel("Infinite solutions", "Unique solution", "No solution", "Infinite solutions", "x = 0 only", "If 0·x = 0, then how many solutions exist?"));
                setUp();
                break;
            case "Geometry":
                quizList.add(new QuizzzModel("180°", "90°", "180°", "270°", "360°", "Sum of angles in a triangle?"));
                quizList.add(new QuizzzModel("πr²", "2πr", "πr²", "4πr²", "πd", "What is the area of a circle?"));
                quizList.add(new QuizzzModel("12 cm", "10 cm", "12 cm", "8 cm", "14 cm", "A square has area 36 cm². Find its perimeter."));
                quizList.add(new QuizzzModel("Pythagoras theorem", "Pythagoras theorem", "Euclid’s postulate", "Thales theorem", "None", "Which theorem states a² + b² = c² in right triangles?"));
                quizList.add(new QuizzzModel("Cone", "Sphere", "Cylinder", "Cone", "Cube", "Which 3D shape has 1 curved surface and 1 circular base?"));
                quizList.add(new QuizzzModel("30 cm²", "25 cm²", "30 cm²", "35 cm²", "40 cm²", "Find the area of a rectangle with length 6 cm and width 5 cm."));
                quizList.add(new QuizzzModel("2r", "2r", "πr", "r²", "r", "What is the diameter of a circle in terms of radius?"));
                quizList.add(new QuizzzModel("Sphere", "Sphere", "Cylinder", "Cube", "Cone", "Which solid has only one surface and no edges?"));
                quizList.add(new QuizzzModel("Parallelogram", "Square", "Rectangle", "Parallelogram", "Trapezium", "Which quadrilateral has opposite sides parallel?"));
                quizList.add(new QuizzzModel("360°", "180°", "270°", "360°", "90°", "Sum of angles in a quadrilateral?"));
                setUp();
                break;

            case "Trigonometry":
                quizList.add(new QuizzzModel("1", "0", "1", "-1", "√2", "What is sin²θ + cos²θ equal to?"));
                quizList.add(new QuizzzModel("1", "1", "0", "∞", "-1", "What is tan 45°?"));
                quizList.add(new QuizzzModel("0", "1", "0", "-1", "√3/2", "What is sin 0°?"));
                quizList.add(new QuizzzModel("√3/2", "1/2", "√3/2", "1", "0", "What is cos 30°?"));
                quizList.add(new QuizzzModel("1", "0", "1", "√2", "-1", "What is sin 90°?"));
                quizList.add(new QuizzzModel("0", "0", "1", "∞", "-1", "What is cos 90°?"));
                quizList.add(new QuizzzModel("√3", "√3", "1/√3", "1", "0", "What is tan 60°?"));
                quizList.add(new QuizzzModel("1", "1", "0", "√3", "∞", "What is sec 0°?"));
                quizList.add(new QuizzzModel("1", "1", "0", "-1", "2", "What is cot 45°?"));
                quizList.add(new QuizzzModel("-1", "0", "1", "-1", "∞", "What is cos 180°?"));
                setUp();
                break;

            case "Probability & Statistics":
                quizList.add(new QuizzzModel("1/6", "1/2", "1/4", "1/6", "1/3", "Probability of getting 4 on a fair dice roll?"));
                quizList.add(new QuizzzModel("52", "26", "13", "52", "54", "How many cards in a standard deck?"));
                quizList.add(new QuizzzModel("1/2", "1/3", "1/4", "1/2", "1/6", "Probability of getting head in a coin toss?"));
                quizList.add(new QuizzzModel("Median", "Mean", "Mode", "Median", "Range", "Which measure is the middle value in ordered data?"));
                quizList.add(new QuizzzModel("Mean", "Mean", "Mode", "Median", "Deviation", "What is the average of numbers called?"));
                quizList.add(new QuizzzModel("Variance", "Variance", "Range", "Median", "Mean", "Which measure tells how data is spread out?"));
                quizList.add(new QuizzzModel("1/13", "1/52", "1/13", "1/26", "1/4", "Probability of drawing a King from a deck?"));
                quizList.add(new QuizzzModel("Normal Distribution", "Normal Distribution", "Poisson", "Binomial", "Uniform", "Which distribution is bell-shaped?"));
                quizList.add(new QuizzzModel("1/3", "1/2", "1/3", "1/6", "1/4", "Probability of rolling even number on dice?"));
                quizList.add(new QuizzzModel("Mode", "Mean", "Median", "Mode", "Range", "Which measure is the most frequent value?"));

                setUp();
                break;

            case "Calculus":
                quizList.add(new QuizzzModel("2x", "x", "2x", "x²", "1/x", "Differentiate: d/dx (x²)"));
                quizList.add(new QuizzzModel("3x²", "2x", "3x²", "x³", "1/x²", "Differentiate: d/dx (x³)"));
                quizList.add(new QuizzzModel("e^x", "e^x", "x·e^x", "ln(x)", "1/x", "Derivative of e^x?"));
                quizList.add(new QuizzzModel("cos x", "cos x", "-cos x", "-sin x", "sec x", "Derivative of sin x?"));
                quizList.add(new QuizzzModel("-sin x", "sin x", "-sin x", "cos x", "tan x", "Derivative of cos x?"));
                quizList.add(new QuizzzModel("ln|x| + C", "x²/2 + C", "ln|x| + C", "1/x + C", "C", "∫ (1/x) dx = ?"));
                quizList.add(new QuizzzModel("x²/2 + C", "x²/2 + C", "x³/3 + C", "x² + C", "2x + C", "∫ x dx = ?"));
                quizList.add(new QuizzzModel("sin x + C", "cos x + C", "sin x + C", "-cos x + C", "tan x + C", "∫ cos x dx = ?"));
                quizList.add(new QuizzzModel("-cos x + C", "sin x + C", "-cos x + C", "tan x + C", "cosec x + C", "∫ sin x dx = ?"));
                quizList.add(new QuizzzModel("1/(x²)", "1/(x²)", "-1/x²", "2x", "ln(x)", "Derivative of -1/x?"));

                setUp();
                break;


                // tech


            case "Programming":

                quizList.add(new QuizzzModel("Java", "Python", "C", "Java", "Ruby", "Which programming language is known as 'Write Once, Run Anywhere'?"));
                quizList.add(new QuizzzModel("Recursion", "Recursion", "Iteration", "Encapsulation", "Polymorphism", "What is the process called where a function calls itself?"));
                quizList.add(new QuizzzModel("Big O Notation", "Big O Notation", "Binary Trees", "Sorting", "Pseudocode", "Which notation describes algorithm time/space complexity?"));
                quizList.add(new QuizzzModel("C", "C", "Java", "Python", "Kotlin", "Which programming language is often called the 'mother of all languages'?"));
                quizList.add(new QuizzzModel("Polymorphism", "Abstraction", "Inheritance", "Polymorphism", "Encapsulation", "Which OOP principle allows objects to take many forms?"));
                quizList.add(new QuizzzModel("Heap", "Stack", "Queue", "Heap", "Linked List", "Which data structure is used for priority scheduling?"));
                quizList.add(new QuizzzModel("Python", "Python", "Java", "C++", "C#", "Which language is most widely used in Artificial Intelligence research?"));
                quizList.add(new QuizzzModel("Compilation", "Interpretation", "Compilation", "Linking", "Execution", "Converting source code into machine code is called?"));
                quizList.add(new QuizzzModel("Git", "Docker", "Git", "Maven", "Gradle", "Which tool is primarily used for version control?"));
                quizList.add(new QuizzzModel("Merge Sort", "Bubble Sort", "Merge Sort", "Selection Sort", "Insertion Sort", "Which sorting algorithm uses a divide-and-conquer approach?"));
                setUp();
                break;

            case "Networking":
                quizList.add(new QuizzzModel("TCP/IP", "HTTP", "TCP/IP", "UDP", "FTP", "Which protocol suite is the foundation of the Internet?"));
                quizList.add(new QuizzzModel("IP Address", "Subnet Mask", "Default Gateway", "IP Address", "DNS", "Which unique number identifies a device on a network?"));
                quizList.add(new QuizzzModel("7", "4", "5", "6", "7", "How many layers are in the OSI model?"));
                quizList.add(new QuizzzModel("DNS", "ARP", "ICMP", "DNS", "SMTP", "Which system translates domain names to IP addresses?"));
                quizList.add(new QuizzzModel("Switch", "Hub", "Router", "Switch", "Firewall", "Which network device works at Layer 2 (Data Link Layer)?"));
                quizList.add(new QuizzzModel("ARP", "ARP", "RARP", "ICMP", "TCP", "Which protocol is used to map IP addresses to MAC addresses?"));
                quizList.add(new QuizzzModel("802.11", "802.3", "802.11", "802.15", "802.16", "Which IEEE standard defines Wi-Fi?"));
                quizList.add(new QuizzzModel("IPv6", "IPv4", "IPv6", "NAT", "MAC", "Which addressing system uses 128-bit addresses?"));
                quizList.add(new QuizzzModel("Ping", "Traceroute", "Ping", "Nslookup", "Telnet", "Which command is used to test connectivity in networking?"));
                quizList.add(new QuizzzModel("SSL/TLS", "SSH", "FTP", "SSL/TLS", "HTTP", "Which protocol secures web traffic with encryption?"));
                setUp();
                break;

            case "Cyber Security":
                quizList.add(new QuizzzModel("Phishing", "Phishing", "Spoofing", "Sniffing", "Spamming", "Which cyberattack tricks users into giving personal info via fake websites/emails?"));
                quizList.add(new QuizzzModel("Firewall", "Antivirus", "Firewall", "VPN", "Proxy", "Which device/software filters traffic between trusted and untrusted networks?"));
                quizList.add(new QuizzzModel("Hashing", "Encryption", "Hashing", "Steganography", "Masking", "Which method is used to ensure data integrity, not confidentiality?"));
                quizList.add(new QuizzzModel("Ransomware", "Trojan", "Worm", "Ransomware", "Spyware", "Which type of malware encrypts files and demands payment?"));
                quizList.add(new QuizzzModel("Zero-Day Attack", "Brute Force", "Zero-Day Attack", "SQL Injection", "Buffer Overflow", "What attack exploits an unknown software vulnerability?"));
                quizList.add(new QuizzzModel("Two-Factor Authentication", "Password", "Captcha", "Firewall", "Two-Factor Authentication", "Which method adds an extra layer of login security?"));
                quizList.add(new QuizzzModel("Denial of Service (DoS)", "Phishing", "Denial of Service (DoS)", "Spoofing", "Keylogging", "Which attack floods a system with traffic to make it unavailable?"));
                quizList.add(new QuizzzModel("Public Key Cryptography", "Public Key Cryptography", "Symmetric Encryption", "Hashing", "Steganography", "Which method uses a pair of keys (private & public)?"));
                quizList.add(new QuizzzModel("Social Engineering", "Sniffing", "Social Engineering", "Spamming", "Brute Force", "Tricking people into giving confidential info is called?"));
                quizList.add(new QuizzzModel("VPN", "Firewall", "VPN", "Proxy", "IDS", "Which technology encrypts all traffic between a user and the internet?"));
                setUp();
                break;

            case "Artificial Intelligence":
                quizList.add(new QuizzzModel("Machine Learning", "Machine Learning", "Deep Learning", "Neural Networks", "AI Ethics", "Which AI field focuses on algorithms that improve with experience?"));
                quizList.add(new QuizzzModel("Alan Turing", "John McCarthy", "Alan Turing", "Elon Musk", "Marvin Minsky", "Who proposed the 'Turing Test' for machine intelligence?"));
                quizList.add(new QuizzzModel("Neural Networks", "Genetic Algorithms", "Neural Networks", "Decision Trees", "Random Forests", "Which AI model is inspired by the human brain?"));
                quizList.add(new QuizzzModel("Supervised Learning", "Supervised Learning", "Unsupervised Learning", "Reinforcement Learning", "Self-Learning", "Which type of learning uses labeled training data?"));
                quizList.add(new QuizzzModel("NLP (Natural Language Processing)", "NLP", "Computer Vision", "Robotics", "Speech Recognition", "Which AI domain deals with language understanding?"));
                quizList.add(new QuizzzModel("Backpropagation", "Gradient Descent", "Backpropagation", "Activation Function", "Dropout", "Which algorithm is key for training neural networks?"));
                quizList.add(new QuizzzModel("IBM Deep Blue", "IBM Deep Blue", "AlphaGo", "ChatGPT", "Watson", "Which AI defeated Garry Kasparov in chess in 1997?"));
                quizList.add(new QuizzzModel("Overfitting", "Overfitting", "Underfitting", "Bias", "Variance", "What term describes when a model memorizes instead of generalizes?"));
                quizList.add(new QuizzzModel("Reinforcement Learning", "Supervised Learning", "Unsupervised Learning", "Reinforcement Learning", "Semi-supervised Learning", "Which learning method uses rewards & punishments?"));
                quizList.add(new QuizzzModel("Singularity", "Singularity", "Neural Net", "AI Bias", "Quantum AI", "What is the hypothetical point where AI surpasses human intelligence?"));
                setUp();
                break;

            case "Databases":
                quizList.add(new QuizzzModel("Primary Key", "Foreign Key", "Composite Key", "Primary Key", "Index", "Which key uniquely identifies a record in a table?"));
                quizList.add(new QuizzzModel("SQL", "NoSQL", "GraphQL", "SQL", "HTML", "Which query language is used to manage relational databases?"));
                quizList.add(new QuizzzModel("ACID", "BASE", "CAP", "ACID", "CRUD", "Which set of properties ensures reliable database transactions?"));
                quizList.add(new QuizzzModel("Normalization", "Denormalization", "Normalization", "Indexing", "Partitioning", "Which process removes redundancy in databases?"));
                quizList.add(new QuizzzModel("MongoDB", "MongoDB", "Oracle", "MySQL", "PostgreSQL", "Which is a popular NoSQL database?"));
                quizList.add(new QuizzzModel("Index", "Index", "Primary Key", "View", "Trigger", "Which database object speeds up query performance?"));
                quizList.add(new QuizzzModel("JOIN", "JOIN", "UNION", "TRUNCATE", "ROLLBACK", "Which SQL command is used to combine rows from multiple tables?"));
                quizList.add(new QuizzzModel("Deadlock", "Transaction", "Rollback", "Deadlock", "Snapshot", "What occurs when two processes wait indefinitely for resources?"));
                quizList.add(new QuizzzModel("Data Warehouse", "Data Warehouse", "Database", "Data Mart", "Data Lake", "Which system is designed for analytical processing (OLAP)?"));
                quizList.add(new QuizzzModel("CAP Theorem", "ACID", "CAP Theorem", "BASE", "2PC", "Which theorem states that a distributed system can only guarantee two of Consistency, Availability, Partition tolerance?"));

                setUp();
                break;


                //  current affairs
            case "National News":
                quizList.add(new QuizzzModel("Chandrayaan-3", "Gaganyaan", "Mangalyaan", "Chandrayaan-3", "Aditya-L1", "Which Indian space mission successfully landed near the Moon’s south pole in 2023?"));
                quizList.add(new QuizzzModel("Narendra Modi", "Amit Shah", "Narendra Modi", "Rajnath Singh", "Droupadi Murmu", "Who inaugurated the new Parliament building of India in May 2023?"));
                quizList.add(new QuizzzModel("Women’s Reservation Bill", "GST Bill", "Women’s Reservation Bill", "Data Protection Bill", "Citizenship Amendment Bill", "Which bill was passed in 2023 providing 33% reservation for women in Lok Sabha and State Assemblies?"));
                quizList.add(new QuizzzModel("Droupadi Murmu", "Pratibha Patil", "Droupadi Murmu", "Indira Gandhi", "Sonia Gandhi", "Who became the 15th President of India and the first tribal woman to hold the post?"));
                quizList.add(new QuizzzModel("Manipur", "Nagaland", "Manipur", "Arunachal Pradesh", "Mizoram", "Which Indian state witnessed ethnic clashes in 2023 leading to a major crisis?"));
                quizList.add(new QuizzzModel("G20 Summit 2023", "COP27", "G20 Summit 2023", "BRICS 2023", "ASEAN Summit", "Which global summit was hosted by India in New Delhi in September 2023?"));
                quizList.add(new QuizzzModel("INS Vikrant", "INS Vikramaditya", "INS Vikrant", "INS Arihant", "INS Kolkata", "What is the name of India’s first indigenously built aircraft carrier commissioned in 2022?"));
                quizList.add(new QuizzzModel("Digital Personal Data Protection Act", "Right to Privacy Act", "Digital Personal Data Protection Act", "IT Act 2000", "Cyber Law Act", "Which law regulating personal data and privacy was passed in India in 2023?"));
                quizList.add(new QuizzzModel("Aditya-L1", "Aditya-L1", "Chandrayaan-2", "RISAT-2", "Mangalyaan", "Which ISRO mission was launched in 2023 to study the Sun?"));
                quizList.add(new QuizzzModel("Article 370 Abrogation (2019)", "GST Reform", "Demonetisation", "Article 370 Abrogation (2019)", "Jan Dhan Yojana", "Which constitutional change removed the special status of Jammu & Kashmir?"));
                setUp();
                break;

            case "International News":
                quizList.add(new QuizzzModel("Russia-Ukraine War", "China-US Trade War", "Russia-Ukraine War", "Israel-Palestine Conflict", "North Korea Crisis", "Which major international conflict has been ongoing since February 2022?"));
                quizList.add(new QuizzzModel("Xi Jinping", "Vladimir Putin", "Xi Jinping", "Joe Biden", "Emmanuel Macron", "Who became President of China for an unprecedented third term in 2023?"));
                quizList.add(new QuizzzModel("COP28 Dubai", "COP28 Dubai", "G20 Bali", "BRICS South Africa", "ASEAN Thailand", "Where was the UN Climate Change Conference COP28 held in 2023?"));
                quizList.add(new QuizzzModel("Sweden & Finland", "Sweden & Finland", "Ukraine & Moldova", "Georgia & Armenia", "Bosnia & Serbia", "Which two countries applied to join NATO after Russia invaded Ukraine?"));
                quizList.add(new QuizzzModel("Rishi Sunak", "Boris Johnson", "Rishi Sunak", "Liz Truss", "Keir Starmer", "Who became the first Indian-origin Prime Minister of the UK in 2022?"));
                quizList.add(new QuizzzModel("Abraham Accords", "Paris Agreement", "Abraham Accords", "Doha Agreement", "Camp David Accords", "What is the name of the peace agreements signed between Israel and Arab nations in recent years?"));
                quizList.add(new QuizzzModel("Xi Jinping", "Xi Jinping", "Narendra Modi", "Yoon Suk-yeol", "Fumio Kishida", "Which leader introduced the 'Belt and Road Initiative' to expand China’s global influence?"));
                quizList.add(new QuizzzModel("UN Security Council", "G20", "UN Security Council", "BRICS", "WTO", "Which global body is criticized for permanent membership limited to 5 countries?"));
                quizList.add(new QuizzzModel("Paris", "Paris", "Brussels", "Berlin", "London", "Where is the headquarters of UNESCO located?"));
                quizList.add(new QuizzzModel("Donald Trump", "Joe Biden", "Donald Trump", "Barack Obama", "George Bush", "Who announced his candidacy for the 2024 U.S. Presidential elections?"));
                setUp();
                break;

            case "Government Policies":
                quizList.add(new QuizzzModel("Ayushman Bharat", "Ayushman Bharat", "PM Kisan", "Ujjwala Yojana", "Digital India", "Which health scheme provides free medical coverage up to ₹5 lakhs for poor families?"));
                quizList.add(new QuizzzModel("Atmanirbhar Bharat", "Start-up India", "Make in India", "Atmanirbhar Bharat", "Digital India", "Which initiative promotes self-reliance and reduces dependency on imports?"));
                quizList.add(new QuizzzModel("Goods and Services Tax (GST)", "Demonetisation", "Goods and Services Tax (GST)", "Digital India", "Jan Dhan Yojana", "Which tax reform merged indirect taxes into a single tax system in India?"));
                quizList.add(new QuizzzModel("Swachh Bharat Abhiyan", "Smart Cities Mission", "Ayushman Bharat", "Swachh Bharat Abhiyan", "PM Awas Yojana", "Which mission was launched in 2014 to improve cleanliness and sanitation in India?"));
                quizList.add(new QuizzzModel("PM Kisan Samman Nidhi", "Ayushman Bharat", "PM Kisan Samman Nidhi", "MUDRA Yojana", "Beti Bachao Beti Padhao", "Which scheme provides income support of ₹6,000 annually to farmers?"));
                quizList.add(new QuizzzModel("Digital India", "Digital India", "Start-up India", "Skill India", "Digital India", "Which program was launched in 2015 to improve online infrastructure and connectivity in India?"));
                quizList.add(new QuizzzModel("RERA Act", "RERA Act", "GST", "DTC", "IBC", "Which 2016 law regulates the real estate sector for transparency and accountability?"));
                quizList.add(new QuizzzModel("Pradhan Mantri Awas Yojana", "Pradhan Mantri Awas Yojana", "Atal Pension Yojana", "Ujjwala Yojana", "Make in India", "Which policy aims to provide affordable housing to all by 2022?"));
                quizList.add(new QuizzzModel("National Education Policy 2020", "National Education Policy 2020", "Digital India", "Skill India", "Ayushman Bharat", "Which policy replaced the 1986 education framework?"));
                quizList.add(new QuizzzModel("Jan Dhan Yojana", "Jan Dhan Yojana", "Ayushman Bharat", "PM Kisan", "Swachh Bharat", "Which scheme was launched to provide bank accounts to every household?"));
                setUp();
                break;

            case "Economy & Finance":
                quizList.add(new QuizzzModel("Nirmala Sitharaman", "Amit Shah", "Rajnath Singh", "Nirmala Sitharaman", "S. Jaishankar", "Who is India’s Finance Minister (2023)?"));
                quizList.add(new QuizzzModel("Repo Rate", "MSF Rate", "Reverse Repo Rate", "Repo Rate", "CRR", "What rate does RBI charge commercial banks for overnight loans?"));
                quizList.add(new QuizzzModel("World Bank", "World Bank", "IMF", "ADB", "WTO", "Which organization publishes the 'Ease of Doing Business' report?"));
                quizList.add(new QuizzzModel("GST", "GST", "VAT", "Excise Duty", "Service Tax", "Which tax system replaced multiple indirect taxes in India from 2017?"));
                quizList.add(new QuizzzModel("Moody’s", "Fitch", "Moody’s", "Standard & Poor’s", "World Bank", "Which of these is a global credit rating agency?"));
                quizList.add(new QuizzzModel("Union Budget", "Union Budget", "Interim Budget", "Railway Budget", "State Budget", "What is the annual financial statement of the Indian government called?"));
                quizList.add(new QuizzzModel("Fiscal Deficit", "Revenue Deficit", "Fiscal Deficit", "Trade Deficit", "Current Account Deficit", "What is the difference between total expenditure and total revenue called?"));
                quizList.add(new QuizzzModel("GDP", "GDP", "FDI", "CPI", "WPI", "The total value of goods and services produced in a country in a year is called?"));
                quizList.add(new QuizzzModel("Bombay Stock Exchange", "NSE", "Bombay Stock Exchange", "London Stock Exchange", "New York Stock Exchange", "What is the oldest stock exchange in Asia?"));
                quizList.add(new QuizzzModel("RBI", "RBI", "SEBI", "IRDAI", "NABARD", "Which organization regulates monetary policy in India?"));
                setUp();
                break;

            case "Science & Tech News":
                quizList.add(new QuizzzModel("James Webb Space Telescope", "Hubble Telescope", "James Webb Space Telescope", "Chandrayaan-2", "Spitzer Telescope", "Which telescope launched in 2021 is providing new images of the early universe?"));
                quizList.add(new QuizzzModel("Aditya-L1", "Aditya-L1", "Mangalyaan", "RISAT", "INSAT", "Which ISRO mission is India’s first solar observatory?"));
                quizList.add(new QuizzzModel("Elon Musk", "Jeff Bezos", "Elon Musk", "Sundar Pichai", "Mark Zuckerberg", "Who is the CEO of SpaceX?"));
                quizList.add(new QuizzzModel("Starlink", "Blue Origin", "OneWeb", "Starlink", "Kuiper", "What is the name of SpaceX’s satellite internet project?"));
                quizList.add(new QuizzzModel("5G", "4G", "3G", "5G", "6G", "Which mobile network technology was officially launched in India in 2022?"));
                quizList.add(new QuizzzModel("CRISPR", "CRISPR", "DNA Fingerprinting", "Polymerase Chain Reaction", "Genome Sequencing", "Which technology allows gene editing with high precision?"));
                quizList.add(new QuizzzModel("ChatGPT", "ChatGPT", "Bard", "Siri", "Alexa", "Which AI chatbot launched in 2022 gained massive global popularity?"));
                quizList.add(new QuizzzModel("ISRO", "NASA", "ESA", "Roscosmos", "ISRO", "Which space agency launched Chandrayaan-3?"));
                quizList.add(new QuizzzModel("Quantum Computing", "Cloud Computing", "Quantum Computing", "Blockchain", "Big Data", "Which emerging technology uses qubits to perform advanced computations?"));
                quizList.add(new QuizzzModel("NISAR", "NISAR", "INSAT", "RISAT", "ASTROSAT", "What is the name of the joint NASA-ISRO satellite to monitor Earth’s ecosystems?"));
                setUp();
                break;

                // mythology

            case "Hindu Mythology":
                quizList.add(new QuizzzModel("Ravana", "Ravana", "Kumbhakarna", "Indrajit", "Vibhishana", "Who was the king of Lanka in the Ramayana?"));
                quizList.add(new QuizzzModel("Arjuna", "Arjuna", "Karna", "Bhima", "Duryodhana", "Who was chosen by Krishna as his charioteer in the Mahabharata?"));
                quizList.add(new QuizzzModel("Ganga", "Yamuna", "Ganga", "Saraswati", "Narmada", "Who was Bhishma’s mother?"));
                quizList.add(new QuizzzModel("Parashurama", "Parashurama", "Bhrigu", "Agastya", "Vishwamitra", "Which sage was known for destroying Kshatriyas 21 times?"));
                quizList.add(new QuizzzModel("Hanuman", "Hanuman", "Sugriva", "Jambavan", "Bali", "Who brought the Sanjeevani herb for Lakshmana?"));
                quizList.add(new QuizzzModel("Draupadi", "Satyavati", "Draupadi", "Kunti", "Gandhari", "Who was known as Panchali in the Mahabharata?"));
                quizList.add(new QuizzzModel("Sudama", "Sudama", "Karna", "Uddhava", "Arjuna", "Which childhood friend of Krishna lived in poverty?"));
                quizList.add(new QuizzzModel("Dasharatha", "Dasharatha", "Janaka", "Harishchandra", "Raghu", "Who was Rama’s father?"));
                quizList.add(new QuizzzModel("Karna", "Karna", "Arjuna", "Bhima", "Nakul", "Who was known as Surya’s son in the Mahabharata?"));
                quizList.add(new QuizzzModel("Kurukshetra", "Kurukshetra", "Mathura", "Ayodhya", "Indraprastha", "Where did the Mahabharata war take place?"));
                setUp();
                break;

            case "Greek Mythology":
                quizList.add(new QuizzzModel("Zeus", "Zeus", "Poseidon", "Hades", "Apollo", "Who was the king of the Greek gods?"));
                quizList.add(new QuizzzModel("Medusa", "Medusa", "Sphinx", "Harpies", "Circe", "Which Gorgon had snakes for hair?"));
                quizList.add(new QuizzzModel("Achilles", "Achilles", "Hercules", "Odysseus", "Perseus", "Who was dipped in the River Styx except for his heel?"));
                quizList.add(new QuizzzModel("Athena", "Athena", "Aphrodite", "Hera", "Artemis", "Which goddess was born from Zeus’s head?"));
                quizList.add(new QuizzzModel("Odysseus", "Odysseus", "Theseus", "Jason", "Agamemnon", "Who took 10 years to return home from Troy?"));
                quizList.add(new QuizzzModel("Hercules", "Hercules", "Perseus", "Achilles", "Theseus", "Who completed 12 labors as punishment?"));
                quizList.add(new QuizzzModel("Pandora", "Pandora", "Helen", "Eurydice", "Clytemnestra", "Who opened the box releasing all evils into the world?"));
                quizList.add(new QuizzzModel("Mount Olympus", "Mount Olympus", "Delphi", "Crete", "Troy", "Where did the Greek gods reside?"));
                quizList.add(new QuizzzModel("Poseidon", "Poseidon", "Ares", "Apollo", "Hermes", "Who was the god of the sea?"));
                quizList.add(new QuizzzModel("Trojan Horse", "Trojan Horse", "Golden Fleece", "Labyrinth", "Pandora’s Box", "What trick was used to capture Troy?"));
                setUp();
                break;


            case "Roman & Norse":
                quizList.add(new QuizzzModel("Odin", "Odin", "Thor", "Loki", "Freyr", "Who was the Allfather in Norse mythology?"));
                quizList.add(new QuizzzModel("Thor", "Thor", "Odin", "Baldur", "Tyr", "Who wielded the hammer Mjölnir?"));
                quizList.add(new QuizzzModel("Loki", "Loki", "Thor", "Heimdall", "Odin", "Who was the trickster god in Norse myths?"));
                quizList.add(new QuizzzModel("Mars", "Mars", "Jupiter", "Neptune", "Mercury", "Who was the Roman god of war?"));
                quizList.add(new QuizzzModel("Jupiter", "Jupiter", "Saturn", "Pluto", "Apollo", "Who was the king of Roman gods?"));
                quizList.add(new QuizzzModel("Valhalla", "Valhalla", "Asgard", "Midgard", "Helheim", "Where did fallen warriors feast in Norse mythology?"));
                quizList.add(new QuizzzModel("Romulus", "Romulus", "Remus", "Aeneas", "Caesar", "Who was the legendary founder of Rome?"));
                quizList.add(new QuizzzModel("Fenrir", "Fenrir", "Jörmungandr", "Sleipnir", "Hati", "Which monstrous wolf was destined to kill Odin?"));
                quizList.add(new QuizzzModel("Saturn", "Saturn", "Mars", "Pluto", "Venus", "Which Roman god was associated with time and harvest?"));
                quizList.add(new QuizzzModel("Ragnarök", "Ragnarök", "Elysium", "Armageddon", "Olympus", "What was the end-of-world event in Norse mythology called?"));
                setUp();
                break;


            case "World Religions":
                quizList.add(new QuizzzModel("Mecca", "Mecca", "Medina", "Jerusalem", "Baghdad", "What is the holiest city in Islam?"));
                quizList.add(new QuizzzModel("Buddha", "Buddha", "Krishna", "Jesus", "Confucius", "Who was born as Siddhartha Gautama?"));
                quizList.add(new QuizzzModel("Jerusalem", "Jerusalem", "Rome", "Bethlehem", "Nazareth", "Which city is sacred to Christianity, Judaism, and Islam?"));
                quizList.add(new QuizzzModel("Vatican City", "Vatican City", "Rome", "Paris", "Istanbul", "Where is the headquarters of the Catholic Church?"));
                quizList.add(new QuizzzModel("Eightfold Path", "Eightfold Path", "Four Vedas", "Ten Commandments", "Five Pillars", "What is the Buddhist path to enlightenment?"));
                quizList.add(new QuizzzModel("Torah", "Torah", "Bible", "Quran", "Tripitaka", "Which text is central to Judaism?"));
                quizList.add(new QuizzzModel("Ramadan", "Ramadan", "Diwali", "Lent", "Hanukkah", "What is the holy fasting month in Islam?"));
                quizList.add(new QuizzzModel("Guru Nanak", "Guru Nanak", "Kabir", "Shankara", "Mahavira", "Who founded Sikhism?"));
                quizList.add(new QuizzzModel("Christianity", "Christianity", "Islam", "Buddhism", "Judaism", "Which religion has the largest number of followers globally?"));
                quizList.add(new QuizzzModel("Moses", "Moses", "Abraham", "David", "Solomon", "Who led the Israelites out of Egypt?"));
                setUp();
                break;

            case "Sacred Texts":
                quizList.add(new QuizzzModel("Vedas", "Vedas", "Puranas", "Upanishads", "Gita", "What are the oldest Hindu scriptures called?"));
                quizList.add(new QuizzzModel("Bible", "Bible", "Torah", "Quran", "Tripitaka", "What is the holy book of Christianity?"));
                quizList.add(new QuizzzModel("Quran", "Quran", "Hadith", "Torah", "Injil", "Which book is considered the word of God in Islam?"));
                quizList.add(new QuizzzModel("Tripitaka", "Tripitaka", "Vinaya", "Jataka", "Sutras", "What is the Buddhist canon of scriptures called?"));
                quizList.add(new QuizzzModel("Bhagavad Gita", "Bhagavad Gita", "Ramayana", "Mahabharata", "Vishnu Purana", "Which Hindu text is a dialogue between Krishna and Arjuna?"));
                quizList.add(new QuizzzModel("Guru Granth Sahib", "Guru Granth Sahib", "Adi Granth", "Rigveda", "Yajurveda", "What is the central scripture of Sikhism?"));
                quizList.add(new QuizzzModel("Dead Sea Scrolls", "Dead Sea Scrolls", "Septuagint", "Book of Mormon", "Talmud", "Which ancient Jewish texts were discovered in caves near Qumran?"));
                quizList.add(new QuizzzModel("Torah", "Torah", "Zohar", "Midrash", "Talmud", "What is the first five books of the Hebrew Bible called?"));
                quizList.add(new QuizzzModel("Analects", "Analects", "Dao De Jing", "Book of Changes", "Shiji", "Which text contains the teachings of Confucius?"));
                quizList.add(new QuizzzModel("Avesta", "Avesta", "Zend", "Rigveda", "Mahabharata", "What is the holy scripture of Zoroastrianism?"));
                setUp();
                break;

                // health

            case "Human Anatomy":
                quizList.add(new QuizzzModel("Liver", "Heart", "Lungs", "Liver", "Kidney", "Which organ is the largest internal organ in the human body?"));
                quizList.add(new QuizzzModel("Cerebellum", "Cerebellum", "Medulla", "Cerebrum", "Thalamus", "Which part of the brain controls balance and coordination?"));
                quizList.add(new QuizzzModel("Femur", "Femur", "Humerus", "Tibia", "Fibula", "What is the longest bone in the human body?"));
                quizList.add(new QuizzzModel("Red Blood Cells", "Red Blood Cells", "White Blood Cells", "Platelets", "Plasma", "Which cells are responsible for carrying oxygen in the blood?"));
                quizList.add(new QuizzzModel("Skin", "Skin", "Liver", "Brain", "Lungs", "What is the largest organ of the human body overall?"));
                quizList.add(new QuizzzModel("Aorta", "Vena Cava", "Pulmonary Vein", "Aorta", "Carotid Artery", "Which is the largest artery in the human body?"));
                quizList.add(new QuizzzModel("Nephrons", "Alveoli", "Nephrons", "Neurons", "Capillaries", "What are the functional units of the kidney called?"));
                quizList.add(new QuizzzModel("Diaphragm", "Diaphragm", "Trachea", "Bronchi", "Pharynx", "Which muscle is primarily responsible for breathing?"));
                quizList.add(new QuizzzModel("Retina", "Lens", "Cornea", "Retina", "Iris", "Which part of the eye contains the light-sensitive cells?"));
                quizList.add(new QuizzzModel("Pancreas", "Liver", "Gallbladder", "Stomach", "Pancreas", "Which organ produces insulin in the human body?"));
                setUp();
                break;

            case "Diseases & Treatment":
                quizList.add(new QuizzzModel("Tuberculosis", "Tuberculosis", "Malaria", "Cholera", "Typhoid", "Which disease is caused by Mycobacterium bacteria?"));
                quizList.add(new QuizzzModel("Insulin", "Insulin", "Glucose", "Adrenaline", "Cortisol", "Which hormone is deficient in diabetes mellitus?"));
                quizList.add(new QuizzzModel("Quinine", "Quinine", "Penicillin", "Aspirin", "Morphine", "Which drug was the first effective treatment for malaria?"));
                quizList.add(new QuizzzModel("Plasmodium", "E. coli", "Salmonella", "Plasmodium", "Streptococcus", "Which parasite causes malaria?"));
                quizList.add(new QuizzzModel("Alexander Fleming", "Louis Pasteur", "Alexander Fleming", "Robert Koch", "Edward Jenner", "Who discovered penicillin?"));
                quizList.add(new QuizzzModel("Rabies", "Rabies", "Polio", "Measles", "Chickenpox", "Which viral disease is also known as hydrophobia?"));
                quizList.add(new QuizzzModel("Dialysis", "Dialysis", "Chemotherapy", "Radiation", "Angioplasty", "Which medical procedure removes waste from the blood when kidneys fail?"));
                quizList.add(new QuizzzModel("Alzheimer’s Disease", "Parkinson’s", "Alzheimer’s Disease", "Epilepsy", "Stroke", "Which disease is characterized by memory loss and dementia?"));
                quizList.add(new QuizzzModel("Bone Marrow", "Bone Marrow", "Liver", "Spleen", "Lymph Nodes", "Where are blood cells primarily produced in the human body?"));
                quizList.add(new QuizzzModel("Chemotherapy", "Chemotherapy", "Dialysis", "Bypass Surgery", "Transplant", "Which treatment uses drugs to kill cancer cells?"));
                setUp();
                break;

            case "Nutrition & Diet":
                quizList.add(new QuizzzModel("Vitamin C", "Vitamin A", "Vitamin B12", "Vitamin C", "Vitamin D", "Which vitamin is essential to prevent scurvy?"));
                quizList.add(new QuizzzModel("Iron", "Iron", "Calcium", "Zinc", "Magnesium", "Which mineral is essential for the production of hemoglobin?"));
                quizList.add(new QuizzzModel("Carbohydrates", "Carbohydrates", "Proteins", "Fats", "Vitamins", "Which macronutrient is the primary source of energy for the body?"));
                quizList.add(new QuizzzModel("Omega-3 Fatty Acids", "Omega-3 Fatty Acids", "Trans Fats", "Cholesterol", "Saturated Fat", "Which nutrient is found in fish oil and is good for heart health?"));
                quizList.add(new QuizzzModel("Vitamin D", "Vitamin A", "Vitamin C", "Vitamin D", "Vitamin K", "Which vitamin is known as the sunshine vitamin?"));
                quizList.add(new QuizzzModel("Proteins", "Proteins", "Carbohydrates", "Lipids", "Nucleic Acids", "Which macronutrient is essential for muscle repair and growth?"));
                quizList.add(new QuizzzModel("Calcium", "Calcium", "Iron", "Phosphorus", "Iodine", "Which mineral is essential for strong bones and teeth?"));
                quizList.add(new QuizzzModel("Vitamin B12", "Vitamin B12", "Vitamin C", "Vitamin D", "Vitamin E", "Deficiency of which vitamin leads to pernicious anemia?"));
                quizList.add(new QuizzzModel("Glycogen", "Starch", "Cellulose", "Glycogen", "Sucrose", "In which form is glucose stored in the human liver and muscles?"));
                quizList.add(new QuizzzModel("Water", "Fats", "Carbs", "Proteins", "Water", "Which nutrient makes up around 60% of the human body?"));
                setUp();
                break;

            case "First Aid":
                quizList.add(new QuizzzModel("CPR", "Bandage", "CPR", "Antibiotics", "Ice Pack", "What is the immediate life-saving technique for cardiac arrest?"));
                quizList.add(new QuizzzModel("Tourniquet", "Tourniquet", "Bandage", "Plaster", "Sling", "What device is used to stop severe bleeding from a limb?"));
                quizList.add(new QuizzzModel("Heimlich Maneuver", "Heimlich Maneuver", "Back Blows", "Mouth-to-mouth", "CPR", "What first-aid procedure is used for choking?"));
                quizList.add(new QuizzzModel("Cool Water", "Cool Water", "Toothpaste", "Butter", "Ice", "What is the correct first aid for minor burns?"));
                quizList.add(new QuizzzModel("Shock", "Shock", "Stroke", "Fever", "Asthma", "What medical emergency is characterized by very low blood pressure and rapid pulse?"));
                quizList.add(new QuizzzModel("Splint", "Splint", "Bandage", "Tourniquet", "Cast", "What should be applied to immobilize a broken bone before medical help?"));
                quizList.add(new QuizzzModel("Antiseptic", "Antiseptic", "Oil", "Vinegar", "Lotion", "What should be applied to disinfect a wound?"));
                quizList.add(new QuizzzModel("Recovery Position", "Flat Position", "Sitting Position", "Recovery Position", "Head Down", "What is the correct position for an unconscious but breathing patient?"));
                quizList.add(new QuizzzModel("Epinephrine", "Aspirin", "Epinephrine", "Antihistamine", "Ibuprofen", "Which injection is used for severe allergic reactions (anaphylaxis)?"));
                quizList.add(new QuizzzModel("ABC (Airway, Breathing, Circulation)", "ABC", "CPR", "AED", "ABCDE", "What is the primary principle of first aid assessment?"));
                setUp();
                break;

            case "Medical Discoveries":
                quizList.add(new QuizzzModel("Edward Jenner", "Edward Jenner", "Louis Pasteur", "Robert Koch", "Alexander Fleming", "Who developed the first successful smallpox vaccine?"));
                quizList.add(new QuizzzModel("X-rays", "MRI", "X-rays", "Ultrasound", "CT Scan", "Which medical imaging technique was discovered by Wilhelm Roentgen?"));
                quizList.add(new QuizzzModel("Jonas Salk", "Jonas Salk", "Albert Sabin", "Louis Pasteur", "Robert Koch", "Who developed the first polio vaccine?"));
                quizList.add(new QuizzzModel("DNA Structure", "Penicillin", "DNA Structure", "Insulin", "Antibiotics", "For what discovery did Watson and Crick win the Nobel Prize?"));
                quizList.add(new QuizzzModel("Alexander Fleming", "Edward Jenner", "Louis Pasteur", "Alexander Fleming", "Joseph Lister", "Who discovered penicillin in 1928?"));
                quizList.add(new QuizzzModel("CT Scan", "X-ray", "MRI", "CT Scan", "PET Scan", "Which imaging method combines X-rays with computer technology to create detailed images?"));
                quizList.add(new QuizzzModel("Insulin", "Adrenaline", "Insulin", "Cortisol", "Glucagon", "Which hormone was first extracted to treat diabetes?"));
                quizList.add(new QuizzzModel("MRI", "X-ray", "CT", "MRI", "Ultrasound", "Which imaging technique uses magnetic fields to view soft tissues?"));
                quizList.add(new QuizzzModel("Louis Pasteur", "Louis Pasteur", "Joseph Lister", "Robert Koch", "Paul Ehrlich", "Who developed the germ theory of disease?"));
                quizList.add(new QuizzzModel("COVID-19 Vaccine", "Penicillin", "Polio Vaccine", "COVID-19 Vaccine", "Smallpox Vaccine", "Which vaccine was first developed using mRNA technology?"));
                setUp();
                break;


                //  logic

            case "Riddles":
                quizList.add(new QuizzzModel("Echo", "Shadow", "Echo", "Whistle", "Silence", "I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?"));
                quizList.add(new QuizzzModel("Candle", "Candle", "Clock", "Battery", "Lamp", "The more you take away from me, the bigger I get. What am I?"));
                quizList.add(new QuizzzModel("Map", "Book", "Map", "Mirror", "Window", "I have cities but no houses, forests but no trees, and rivers but no water. What am I?"));
                quizList.add(new QuizzzModel("Keyboard", "Keyboard", "Piano", "Calculator", "Remote", "I have keys but no locks. I have space but no room. You can enter but not go outside. What am I?"));
                quizList.add(new QuizzzModel("Secret", "Breath", "Shadow", "Secret", "Name", "The more of me you share, the less I am. What am I?"));
                quizList.add(new QuizzzModel("Fire", "Fire", "Water", "Wind", "Ice", "Feed me and I live, yet give me a drink and I die. What am I?"));
                quizList.add(new QuizzzModel("Future", "Past", "Dream", "Future", "Hope", "I am always ahead of you but can never be seen. What am I?"));
                quizList.add(new QuizzzModel("Needle", "Pen", "Sword", "Needle", "Knife", "I have an eye but cannot see. What am I?"));
                quizList.add(new QuizzzModel("Shadow", "Shadow", "Echo", "Cloud", "Reflection", "The more you take from me, the more I grow. What am I?"));
                quizList.add(new QuizzzModel("Time", "Money", "Time", "Energy", "Light", "I am free, yet priceless. You can never own me. What am I?"));
                setUp();
                break;

            case "Pattern Recognition":
                quizList.add(new QuizzzModel("9", "7", "8", "9", "10", "Find the missing number: 2, 4, 6, ?, 10"));
                quizList.add(new QuizzzModel("16", "12", "14", "16", "18", "Find the next square number: 1, 4, 9, ?"));
                quizList.add(new QuizzzModel("21", "15", "18", "21", "24", "What comes next: 3, 6, 9, ?, 15"));
                quizList.add(new QuizzzModel("F", "D", "E", "F", "G", "Find the missing letter: A, C, E, ?"));
                quizList.add(new QuizzzModel("64", "32", "48", "64", "80", "Find the next cube number: 8, 27, ?"));
                quizList.add(new QuizzzModel("144", "100", "121", "144", "169", "What comes next: 25, 36, 49, ?, 81"));
                quizList.add(new QuizzzModel("11", "7", "9", "11", "13", "Find the next prime: 2, 3, 5, 7, ?"));
                quizList.add(new QuizzzModel("J", "H", "I", "J", "K", "Fill the missing: F, G, H, ?, L"));
                quizList.add(new QuizzzModel("34", "13", "21", "34", "55", "What comes next in Fibonacci: 5, 8, 13, 21, ?"));
                quizList.add(new QuizzzModel("100", "60", "80", "90", "100", "Complete the sequence: 20, 40, 60, 80, ?"));
                setUp();
                break;

            case "Math Puzzles":
                quizList.add(new QuizzzModel("5", "3", "4", "5", "6", "If 2x + 3 = 13, what is x?"));
                quizList.add(new QuizzzModel("81", "64", "72", "81", "90", "Solve: 9² = ?"));
                quizList.add(new QuizzzModel("20", "15", "18", "20", "25", "What is 5! (factorial)?"));
                quizList.add(new QuizzzModel("8", "6", "7", "8", "9", "Solve for x: 2x = 16"));
                quizList.add(new QuizzzModel("1/6", "1/4", "1/5", "1/6", "1/7", "If a dice is rolled, what is probability of getting 6?"));
                quizList.add(new QuizzzModel("25", "16", "20", "25", "30", "What is (3² + 4²)?"));
                quizList.add(new QuizzzModel("2", "2", "3", "4", "5", "Solve: log₂(4) = ?"));
                quizList.add(new QuizzzModel("10", "6", "8", "10", "12", "If the perimeter of a square is 40, its side is?"));
                quizList.add(new QuizzzModel("27", "9", "18", "27", "36", "What is 3³?"));
                quizList.add(new QuizzzModel("0", "0", "1", "-1", "2", "What is sin(180°)?"));
                setUp();
                break;

            case "Reasoning":
                quizList.add(new QuizzzModel("Elephant", "Dog", "Cat", "Elephant", "Rabbit", "Odd one out: Dog, Cat, Elephant, Rabbit"));
                quizList.add(new QuizzzModel("E", "C", "D", "E", "F", "What comes next: A, B, C, D, ?"));
                quizList.add(new QuizzzModel("Blue", "Blue", "Green", "Yellow", "Red", "Which is not a primary color?"));
                quizList.add(new QuizzzModel("Triangle", "Square", "Triangle", "Pentagon", "Hexagon", "Shape with 3 sides?"));
                quizList.add(new QuizzzModel("March", "January", "February", "March", "April", "Which month has 31 days?"));
                quizList.add(new QuizzzModel("Africa", "Asia", "Africa", "Europe", "Australia", "Which continent is known as Dark Continent?"));
                quizList.add(new QuizzzModel("Oxygen", "Hydrogen", "Oxygen", "Carbon", "Nitrogen", "Essential gas for breathing?"));
                quizList.add(new QuizzzModel("8", "6", "7", "8", "9", "How many sides does an octagon have?"));
                quizList.add(new QuizzzModel("Mercury", "Mercury", "Venus", "Earth", "Mars", "Closest planet to the Sun?"));
                quizList.add(new QuizzzModel("Shakespeare", "Milton", "Wordsworth", "Shakespeare", "Keats", "Who wrote Romeo & Juliet?"));
                setUp();
                break;


            case "Critical Thinking":
                quizList.add(new QuizzzModel("Assumption", "Fact", "Opinion", "Assumption", "Belief", "If you say 'All cats have four legs,' what type of statement is it?"));
                quizList.add(new QuizzzModel("Deduction", "Deduction", "Induction", "Prediction", "Assumption", "Which reasoning moves from general to specific?"));
                quizList.add(new QuizzzModel("Bias", "Logic", "Truth", "Bias", "Reasoning", "When a conclusion is influenced by personal opinions, it is called?"));
                quizList.add(new QuizzzModel("Hypothesis", "Hypothesis", "Law", "Theory", "Fact", "A testable statement in research is called?"));
                quizList.add(new QuizzzModel("Fallacy", "Proof", "Evidence", "Fallacy", "Reason", "A misleading argument due to false logic is known as?"));
                quizList.add(new QuizzzModel("Contradiction", "Agreement", "Contradiction", "Proof", "Conclusion", "When two statements oppose each other directly, it is a?"));
                quizList.add(new QuizzzModel("Paradox", "Mystery", "Paradox", "Riddle", "Dilemma", "A situation that contradicts itself but might be true is called?"));
                quizList.add(new QuizzzModel("Causation", "Correlation", "Causation", "Assumption", "Guess", "When one event directly causes another, it is called?"));
                quizList.add(new QuizzzModel("Inference", "Judgment", "Inference", "Guess", "Bias", "Drawing a conclusion based on evidence is called?"));
                quizList.add(new QuizzzModel("Analysis", "Opinion", "Decision", "Analysis", "Guess", "Breaking down complex information into parts is known as?"));
                setUp();
                break;

                // entertainment


            case "Movies":
                quizList.add(new QuizzzModel("Parasite", "1917", "Joker", "Parasite", "Once Upon a Time in Hollywood", "Which film won the Best Picture Oscar in 2020?"));
                quizList.add(new QuizzzModel("Rashomon", "Rashomon", "Seven Samurai", "Tokyo Story", "Ikiru", "Akira Kurosawa popularized the 'Rashomon effect' with which film?"));
                quizList.add(new QuizzzModel("Sholay", "Sholay", "Mughal-e-Azam", "Dilwale Dulhania Le Jayenge", "Mother India", "Which Indian movie is often called the 'Curry Western'?"));
                quizList.add(new QuizzzModel("Citizen Kane", "Citizen Kane", "The Godfather", "Casablanca", "Pulp Fiction", "Which film is often considered the greatest of all time by critics?"));
                quizList.add(new QuizzzModel("Spirited Away", "Spirited Away", "My Neighbor Totoro", "Akira", "Your Name", "Which Japanese animated film won the Academy Award in 2003?"));
                quizList.add(new QuizzzModel("Titanic", "Titanic", "Avatar", "The Lord of the Rings", "Gladiator", "Which film tied with 'Ben-Hur' and 'LOTR: Return of the King' for most Oscars (11)?"));
                quizList.add(new QuizzzModel("Baahubali 2", "Baahubali 2", "RRR", "Dangal", "KGF", "Which Indian film was the first to gross over ₹1,000 crore worldwide?"));
                quizList.add(new QuizzzModel("Inception", "Inception", "Interstellar", "Memento", "Tenet", "Which Christopher Nolan film is famous for the 'spinning top' ending?"));
                quizList.add(new QuizzzModel("The Godfather Part II", "The Godfather Part II", "The Dark Knight", "Goodfellas", "Schindler’s List", "Which sequel won the Academy Award for Best Picture?"));
                quizList.add(new QuizzzModel("Pather Panchali", "Pather Panchali", "Charulata", "Aparajito", "Shatranj Ke Khilari", "Which Satyajit Ray film is the first in the Apu Trilogy?"));
                setUp();
                break;

            case "Music":
                quizList.add(new QuizzzModel("The Beatles", "The Beatles", "The Rolling Stones", "Pink Floyd", "Led Zeppelin", "Which band holds the record for the most #1 hits on the Billboard Hot 100?"));
                quizList.add(new QuizzzModel("AR Rahman", "AR Rahman", "Ilaiyaraaja", "Shankar–Ehsaan–Loy", "Anu Malik", "Who is known as the 'Mozart of Madras'?"));
                quizList.add(new QuizzzModel("Thriller", "Thriller", "Back in Black", "The Dark Side of the Moon", "Hotel California", "What is the best-selling album of all time?"));
                quizList.add(new QuizzzModel("BTS", "EXO", "BTS", "Blackpink", "Seventeen", "Which K-pop group has topped the Billboard Hot 100 multiple times?"));
                quizList.add(new QuizzzModel("Mozart", "Beethoven", "Mozart", "Bach", "Chopin", "Who composed 'The Magic Flute' opera?"));
                quizList.add(new QuizzzModel("Shakira", "Jennifer Lopez", "Shakira", "Beyoncé", "Rihanna", "Which singer performed 'Waka Waka' for the 2010 FIFA World Cup?"));
                quizList.add(new QuizzzModel("Grammy Awards", "Billboard Awards", "American Music Awards", "Grammy Awards", "MTV VMAs", "Which award is considered the highest honor in the music industry?"));
                quizList.add(new QuizzzModel("Bob Dylan", "Elvis Presley", "Bob Dylan", "Paul Simon", "Johnny Cash", "Which artist won the Nobel Prize in Literature in 2016 for songwriting?"));
                quizList.add(new QuizzzModel("Adele", "Taylor Swift", "Adele", "Lady Gaga", "Katy Perry", "Who sang the James Bond theme 'Skyfall'?"));
                quizList.add(new QuizzzModel("MTV", "MTV", "VH1", "Channel V", "BBC Music", "Which TV channel popularized music videos in the 1980s?"));
                setUp();
                break;

            case "TV Shows & Series":
                quizList.add(new QuizzzModel("Breaking Bad", "Breaking Bad", "Game of Thrones", "The Sopranos", "Mad Men", "Which series is about a chemistry teacher turned drug kingpin?"));
                quizList.add(new QuizzzModel("FRIENDS", "FRIENDS", "How I Met Your Mother", "The Big Bang Theory", "Seinfeld", "Which sitcom features Central Perk café?"));
                quizList.add(new QuizzzModel("Chernobyl", "Chernobyl", "The Crown", "Band of Brothers", "Mindhunter", "Which HBO mini-series depicted the 1986 nuclear disaster?"));
                quizList.add(new QuizzzModel("The Office", "The Office", "Parks and Recreation", "Brooklyn Nine-Nine", "Scrubs", "Which show popularized 'That's what she said' jokes?"));
                quizList.add(new QuizzzModel("Sacred Games", "Sacred Games", "Mirzapur", "The Family Man", "Paatal Lok", "Which was the first Netflix Original series from India?"));
                quizList.add(new QuizzzModel("Doctor Who", "Doctor Who", "Sherlock", "Stranger Things", "Dark", "Which is the longest-running sci-fi TV show in history?"));
                quizList.add(new QuizzzModel("Money Heist", "Money Heist", "Breaking Bad", "Narcos", "Prison Break", "Which Spanish series features characters named after cities?"));
                quizList.add(new QuizzzModel("Game of Thrones", "Vikings", "Game of Thrones", "The Witcher", "House of the Dragon", "Which fantasy series is based on George R.R. Martin’s books?"));
                quizList.add(new QuizzzModel("Fargo", "True Detective", "Fargo", "The Wire", "Narcos", "Which anthology series is based on a Coen Brothers film?"));
                quizList.add(new QuizzzModel("The Simpsons", "The Simpsons", "Family Guy", "Rick and Morty", "South Park", "Which animated sitcom is the longest-running American TV show?"));
                setUp();
                break;


            case "Celebrities":
                quizList.add(new QuizzzModel("Leonardo DiCaprio", "Brad Pitt", "Tom Cruise", "Leonardo DiCaprio", "Johnny Depp", "Who finally won an Oscar for 'The Revenant' in 2016?"));
                quizList.add(new QuizzzModel("Oprah Winfrey", "Oprah Winfrey", "Ellen DeGeneres", "Barbara Walters", "Martha Stewart", "Who is known as the 'Queen of Talk Shows'?"));
                quizList.add(new QuizzzModel("Virat Kohli", "MS Dhoni", "Virat Kohli", "Sachin Tendulkar", "Rohit Sharma", "Which cricketer married Bollywood actress Anushka Sharma?"));
                quizList.add(new QuizzzModel("Elon Musk", "Jeff Bezos", "Elon Musk", "Bill Gates", "Mark Zuckerberg", "Who is the CEO of SpaceX and Tesla?"));
                quizList.add(new QuizzzModel("Priyanka Chopra", "Deepika Padukone", "Priyanka Chopra", "Alia Bhatt", "Kareena Kapoor", "Which Indian actress starred in the American TV series 'Quantico'?"));
                quizList.add(new QuizzzModel("Beyoncé", "Beyoncé", "Rihanna", "Adele", "Nicki Minaj", "Who released the visual album 'Lemonade'?"));
                quizList.add(new QuizzzModel("Shah Rukh Khan", "Aamir Khan", "Shah Rukh Khan", "Salman Khan", "Ranbir Kapoor", "Who is known as the 'King of Bollywood'?"));
                quizList.add(new QuizzzModel("Cristiano Ronaldo", "Lionel Messi", "Cristiano Ronaldo", "Neymar", "Kylian Mbappé", "Which footballer has the most Instagram followers (2023)?"));
                quizList.add(new QuizzzModel("Taylor Swift", "Billie Eilish", "Ariana Grande", "Taylor Swift", "Selena Gomez", "Which singer is known for albums like '1989' and 'Folklore'?"));
                quizList.add(new QuizzzModel("Keanu Reeves", "Keanu Reeves", "Tom Hardy", "Hugh Jackman", "Chris Evans", "Which actor is famously nicknamed 'the Internet’s boyfriend'?"));
                setUp();
                break;


            case "Gaming":
                quizList.add(new QuizzzModel("Minecraft", "Minecraft", "Fortnite", "PUBG", "Roblox", "Which game is the best-selling video game of all time?"));
                quizList.add(new QuizzzModel("Shigeru Miyamoto", "Shigeru Miyamoto", "Hideo Kojima", "Sid Meier", "Gabe Newell", "Who created Super Mario and The Legend of Zelda?"));
                quizList.add(new QuizzzModel("League of Legends", "League of Legends", "Dota 2", "CS:GO", "Valorant", "Which game hosts the annual 'Worlds' eSports championship?"));
                quizList.add(new QuizzzModel("Sony PlayStation", "Sega Genesis", "Sony PlayStation", "Nintendo 64", "Xbox", "Which console introduced CDs instead of cartridges in 1994?"));
                quizList.add(new QuizzzModel("PUBG", "Call of Duty", "Fortnite", "PUBG", "Apex Legends", "Which game popularized the Battle Royale genre globally?"));
                quizList.add(new QuizzzModel("The Witcher 3", "The Witcher 3", "Skyrim", "Elden Ring", "Cyberpunk 2077", "Which RPG is based on books by Andrzej Sapkowski?"));
                quizList.add(new QuizzzModel("Pikachu", "Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Which Pokémon is the franchise’s official mascot?"));
                quizList.add(new QuizzzModel("Counter-Strike", "Halo", "Counter-Strike", "Call of Duty", "Overwatch", "Which FPS series introduced 'Terrorists vs Counter-Terrorists'?"));
                quizList.add(new QuizzzModel("Nintendo", "Nintendo", "Sony", "Microsoft", "Atari", "Which company created the Game Boy handheld console?"));
                quizList.add(new QuizzzModel("Dark Souls", "Dark Souls", "Bloodborne", "Sekiro", "Elden Ring", "Which game popularized the term 'Prepare to Die' difficulty?"));
                setUp();
                break;


                // gk

            case "Sports":
            quizList.add(new QuizzzModel("Roger Federer", "Roger Federer", "Rafael Nadal", "Novak Djokovic", "Pete Sampras", "Who holds the record for the most Wimbledon men’s singles titles?"));
            quizList.add(new QuizzzModel("1930", "1930", "1934", "1928", "1938", "In which year was the first FIFA World Cup held?"));
            quizList.add(new QuizzzModel("Sachin Tendulkar", "Ricky Ponting", "Brian Lara", "Sachin Tendulkar", "Jacques Kallis", "Who is known as the 'God of Cricket'?"));
            quizList.add(new QuizzzModel("Michael Phelps", "Michael Phelps", "Usain Bolt", "Mark Spitz", "Carl Lewis", "Who has won the most Olympic gold medals in history?"));
            quizList.add(new QuizzzModel("India", "India", "Australia", "Pakistan", "England", "Which country won the 1983 Cricket World Cup?"));
            quizList.add(new QuizzzModel("Super Bowl", "Super Bowl", "World Series", "Stanley Cup", "NBA Finals", "Which sporting event decides the champion of American football?"));
            quizList.add(new QuizzzModel("Lewis Hamilton", "Lewis Hamilton", "Michael Schumacher", "Ayrton Senna", "Sebastian Vettel", "Who has won the most Formula 1 World Championships (tied with Schumacher)?"));
            quizList.add(new QuizzzModel("Kabbadi", "Kho Kho", "Kabbadi", "Polo", "Hockey", "Which is the national sport of Bangladesh?"));
            quizList.add(new QuizzzModel("Don Bradman", "Don Bradman", "Sunil Gavaskar", "Viv Richards", "Steve Waugh", "Who had a career batting average of 99.94 in Test cricket?"));
            quizList.add(new QuizzzModel("Tour de France", "Tour de France", "La Vuelta", "Giro d’Italia", "Paris–Roubaix", "Which cycling race is considered the most prestigious in the world?"));
                setUp();
                break;

            case "Geography":

                quizList.add(new QuizzzModel("Nile", "Amazon", "Yangtze", "Mississippi", "Nile", "What is the longest river in the world?"));
            quizList.add(new QuizzzModel("Mount Everest", "K2", "Mount Everest", "Kanchenjunga", "Lhotse", "Which is the highest mountain above sea level?"));
            quizList.add(new QuizzzModel("Vatican City", "Monaco", "Vatican City", "San Marino", "Liechtenstein", "Which is the smallest country in the world by area?"));
            quizList.add(new QuizzzModel("Australia", "Australia", "Greenland", "Madagascar", "Antarctica", "Which is the smallest continent by land area?"));
            quizList.add(new QuizzzModel("Sahara Desert", "Gobi Desert", "Kalahari Desert", "Sahara Desert", "Arabian Desert", "What is the largest hot desert in the world?"));
            quizList.add(new QuizzzModel("Pacific Ocean", "Atlantic Ocean", "Pacific Ocean", "Indian Ocean", "Southern Ocean", "Which is the largest ocean in the world?"));
            quizList.add(new QuizzzModel("Russia", "China", "Canada", "Russia", "Brazil", "Which country has the largest land area in the world?"));
            quizList.add(new QuizzzModel("Lake Baikal", "Lake Baikal", "Caspian Sea", "Lake Superior", "Lake Victoria", "Which is the deepest lake in the world?"));
            quizList.add(new QuizzzModel("Equator", "Prime Meridian", "Tropic of Cancer", "Equator", "Arctic Circle", "Which imaginary line divides the Earth into Northern and Southern Hemispheres?"));
            quizList.add(new QuizzzModel("Tokyo", "Tokyo", "New York", "Shanghai", "Delhi", "Which city is the most populated in the world (metro area)?"));

                setUp();
                break;

            case "Famous Personalities":

                quizList.add(new QuizzzModel("Albert Einstein", "Albert Einstein", "Isaac Newton", "Nikola Tesla", "Galileo Galilei", "Who developed the theory of relativity?"));
            quizList.add(new QuizzzModel("Mahatma Gandhi", "Jawaharlal Nehru", "Mahatma Gandhi", "Sardar Patel", "Subhash Chandra Bose", "Who is called the Father of the Nation in India?"));
            quizList.add(new QuizzzModel("Marie Curie", "Rosalind Franklin", "Ada Lovelace", "Marie Curie", "Dorothy Hodgkin", "Who was the first woman to win a Nobel Prize?"));
            quizList.add(new QuizzzModel("Elon Musk", "Jeff Bezos", "Bill Gates", "Elon Musk", "Warren Buffett", "Who is the founder of SpaceX?"));
            quizList.add(new QuizzzModel("Leonardo da Vinci", "Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo", "Who painted the Mona Lisa?"));
            quizList.add(new QuizzzModel("Nelson Mandela", "Martin Luther King Jr.", "Barack Obama", "Nelson Mandela", "Desmond Tutu", "Who was the first black president of South Africa?"));
            quizList.add(new QuizzzModel("Wright Brothers", "Thomas Edison", "Nikola Tesla", "Wright Brothers", "Alexander Graham Bell", "Who invented the first successful airplane?"));
            quizList.add(new QuizzzModel("Malala Yousafzai", "Mother Teresa", "Malala Yousafzai", "Greta Thunberg", "Rosa Parks", "Who is the youngest Nobel Peace Prize laureate?"));
            quizList.add(new QuizzzModel("William Shakespeare", "William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain", "Who is often called the 'Bard of Avon'?"));
            quizList.add(new QuizzzModel("Steve Jobs", "Larry Page", "Steve Jobs", "Mark Zuckerberg", "Sergey Brin", "Who co-founded Apple Inc.?"));


                setUp();
                break;

            case "History":
                quizList.add(new QuizzzModel("Genghis Khan", "Napoleon", "Alexander the Great", "Genghis Khan", "Attila", "Who founded the largest contiguous land empire in history?"));
                quizList.add(new QuizzzModel("Battle of Hastings", "Battle of Waterloo", "Battle of Hastings", "Battle of Agincourt", "Battle of Leipzig", "Which 1066 battle led to the Norman conquest of England?"));
                quizList.add(new QuizzzModel("Rosetta Stone", "Dead Sea Scrolls", "Magna Carta", "Rosetta Stone", "Epic of Gilgamesh", "Which artifact helped decipher Egyptian hieroglyphs?"));
                quizList.add(new QuizzzModel("Treaty of Versailles", "Treaty of Versailles", "Treaty of Paris", "Treaty of Ghent", "Treaty of Westphalia", "Which treaty ended World War I in 1919?"));
                quizList.add(new QuizzzModel("Chernobyl", "Three Mile Island", "Chernobyl", "Fukushima", "Bhopal Gas Tragedy", "Where did the catastrophic nuclear accident occur in 1986?"));
                quizList.add(new QuizzzModel("Mughal Empire", "Maurya", "Gupta", "Mughal Empire", "Kushan", "Which dynasty built the Taj Mahal?"));
                quizList.add(new QuizzzModel("Constantinople", "Constantinople", "Athens", "Rome", "Alexandria", "What was the capital of the Byzantine Empire?"));
                quizList.add(new QuizzzModel("Opium Wars", "Opium Wars", "Taiping Rebellion", "Boxer Rebellion", "Sino-Japanese War", "Which 19th-century conflict forced China to trade with Britain?"));
                quizList.add(new QuizzzModel("Nelson Mandela", "Mahatma Gandhi", "Nelson Mandela", "Kwame Nkrumah", "Desmond Tutu", "Who became South Africa’s first Black president in 1994?"));
                quizList.add(new QuizzzModel("Silk Road", "Spice Route", "Silk Road", "Amber Road", "Salt Route", "Which ancient trade network connected China with Europe?"));
                setUp();
                break;

            case "Culture & Heritage":
                quizList.add(new QuizzzModel("UNESCO", "UNESCO", "WHO", "IMF", "UNICEF", "Which organization designates World Heritage Sites?"));
                quizList.add(new QuizzzModel("Ellora Caves", "Ajanta Caves", "Ellora Caves", "Elephanta Caves", "Badami Caves", "Kailasa temple is located in which cave complex in India?"));
                quizList.add(new QuizzzModel("Machu Picchu", "Petra", "Machu Picchu", "Angkor Wat", "Great Wall of China", "Which Incan city in Peru is one of the Seven Wonders of the World?"));
                quizList.add(new QuizzzModel("Borobudur", "Borobudur", "Angkor Wat", "Bagan", "Prambanan", "Which is the largest Buddhist temple in the world?"));
                quizList.add(new QuizzzModel("Kathakali", "Bharatanatyam", "Odissi", "Kathakali", "Mohiniyattam", "Which classical Indian dance form is known for elaborate makeup and storytelling?"));
                quizList.add(new QuizzzModel("Terracotta Army", "Moai Statues", "Stonehenge", "Terracotta Army", "Easter Island", "Which archaeological discovery was found in the tomb of China’s First Emperor?"));
                quizList.add(new QuizzzModel("Parthenon", "Pantheon", "Parthenon", "Colosseum", "Acropolis", "Which ancient temple in Athens is dedicated to Athena?"));
                quizList.add(new QuizzzModel("Carnival", "Oktoberfest", "Carnival", "La Tomatina", "Mardi Gras", "Which Brazilian festival is famous for samba parades?"));
                quizList.add(new QuizzzModel("Nalanda University", "Takshashila", "Nalanda University", "Vikramshila", "Jagaddala", "Which ancient Indian university was destroyed by invaders in the 12th century?"));
                quizList.add(new QuizzzModel("Moai Statues", "Moai Statues", "Nazca Lines", "Stonehenge", "Great Zimbabwe", "The giant stone heads on Easter Island are called what?"));
                setUp();
                break;


                //  Literature


            case "English Literature":

                quizList.add(new QuizzzModel("William Shakespeare", "William Shakespeare", "Geoffrey Chaucer", "John Milton", "Christopher Marlowe", "Who wrote 'A Midsummer Night’s Dream'?"));
                quizList.add(new QuizzzModel("Paradise Lost", "Paradise Lost", "Divine Comedy", "Canterbury Tales", "Beowulf", "Which epic poem was written by John Milton?"));
                quizList.add(new QuizzzModel("George Orwell", "George Orwell", "Aldous Huxley", "Ernest Hemingway", "T.S. Eliot", "Who wrote the novel '1984'?"));
                quizList.add(new QuizzzModel("Hamlet", "Hamlet", "Othello", "King Lear", "Macbeth", "Which play begins with the line 'Who’s there?'"));
                quizList.add(new QuizzzModel("Jane Austen", "Jane Austen", "Emily Brontë", "Mary Shelley", "Charlotte Brontë", "Who wrote 'Pride and Prejudice'?"));
                quizList.add(new QuizzzModel("Geoffrey Chaucer", "William Langland", "Geoffrey Chaucer", "Thomas Malory", "John Gower", "Who is considered the 'Father of English Poetry'?"));
                quizList.add(new QuizzzModel("W.B. Yeats", "W.B. Yeats", "Seamus Heaney", "T.S. Eliot", "Sylvia Plath", "Who wrote the poem 'The Second Coming'?"));
                quizList.add(new QuizzzModel("Beowulf", "Sir Gawain and the Green Knight", "Beowulf", "Le Morte d’Arthur", "The Wanderer", "Which is the oldest surviving epic poem in Old English?"));
                quizList.add(new QuizzzModel("Virginia Woolf", "Virginia Woolf", "George Eliot", "Elizabeth Barrett Browning", "Emily Dickinson", "Who wrote the modernist novel 'Mrs Dalloway'?"));
                quizList.add(new QuizzzModel("J.R.R. Tolkien", "J.K. Rowling", "C.S. Lewis", "J.R.R. Tolkien", "Philip Pullman", "Who wrote 'The Lord of the Rings'?"));


                setUp();
                break;

            case "World Literature":

                quizList.add(new QuizzzModel("Dante Alighieri", "Dante Alighieri", "Homer", "Virgil", "Sophocles", "Who wrote 'The Divine Comedy'?"));
                quizList.add(new QuizzzModel("Homer", "Homer", "Virgil", "Plato", "Aristotle", "Who is traditionally credited with writing 'The Iliad' and 'The Odyssey'?"));
                quizList.add(new QuizzzModel("Leo Tolstoy", "Fyodor Dostoevsky", "Anton Chekhov", "Leo Tolstoy", "Maxim Gorky", "Who wrote 'War and Peace'?"));
                quizList.add(new QuizzzModel("Gabriel García Márquez", "Gabriel García Márquez", "Isabel Allende", "Mario Vargas Llosa", "Jorge Luis Borges", "Who wrote 'One Hundred Years of Solitude'?"));
                quizList.add(new QuizzzModel("Cervantes", "Cervantes", "Goethe", "Voltaire", "Molière", "Who is the author of 'Don Quixote'?"));
                quizList.add(new QuizzzModel("Albert Camus", "Albert Camus", "Jean-Paul Sartre", "Franz Kafka", "Milan Kundera", "Who wrote the novel 'The Stranger'?"));
                quizList.add(new QuizzzModel("Victor Hugo", "Victor Hugo", "Alexandre Dumas", "Balzac", "Molière", "Who wrote 'Les Misérables'?"));
                quizList.add(new QuizzzModel("Franz Kafka", "Franz Kafka", "Nietzsche", "Thomas Mann", "Stefan Zweig", "Who wrote the novella 'The Metamorphosis'?"));
                quizList.add(new QuizzzModel("Haruki Murakami", "Haruki Murakami", "Kenzaburō Ōe", "Kazuo Ishiguro", "Yasunari Kawabata", "Which Japanese author wrote 'Kafka on the Shore'?"));
                quizList.add(new QuizzzModel("Sophocles", "Euripides", "Aeschylus", "Sophocles", "Aristophanes", "Who wrote the tragedy 'Oedipus Rex'?"));


                setUp();
                break;

            case "Indian Literature":
                quizList.add(new QuizzzModel("Valmiki", "Valmiki", "Vyasa", "Kalidasa", "Tulsidas", "Who is traditionally credited with writing the Ramayana?"));
                quizList.add(new QuizzzModel("Vyasa", "Vyasa", "Valmiki", "Bhasa", "Kalhana", "Who composed the Mahabharata?"));
                quizList.add(new QuizzzModel("Kalidasa", "Kalidasa", "Bharavi", "Bhavabhuti", "Bhasa", "Who wrote the classical Sanskrit play 'Shakuntala'?"));
                quizList.add(new QuizzzModel("Rabindranath Tagore", "Rabindranath Tagore", "Bankim Chandra Chattopadhyay", "Sarojini Naidu", "Premchand", "Who wrote 'Gitanjali', which won the Nobel Prize in Literature?"));
                quizList.add(new QuizzzModel("Bankim Chandra Chattopadhyay", "Bankim Chandra Chattopadhyay", "Rabindranath Tagore", "Sarojini Naidu", "Premchand", "Who wrote the novel 'Anandamath', featuring 'Vande Mataram'?"));
                quizList.add(new QuizzzModel("Premchand", "Premchand", "Harivansh Rai Bachchan", "Ramdhari Singh Dinkar", "Suryakant Tripathi Nirala", "Who is known as the 'Upanyas Samrat' (Emperor of Novels) in Hindi literature?"));
                quizList.add(new QuizzzModel("Amrita Pritam", "Amrita Pritam", "Mahadevi Verma", "Kamala Das", "Ismat Chughtai", "Who wrote the famous Punjabi novel 'Pinjar'?"));
                quizList.add(new QuizzzModel("Kabir", "Kabir", "Tulsidas", "Surdas", "Meerabai", "Which saint poet is known for his dohas and Nirgun Bhakti poetry?"));
                quizList.add(new QuizzzModel("RK Narayan", "RK Narayan", "Mulk Raj Anand", "Khushwant Singh", "Salman Rushdie", "Who created the fictional town of Malgudi?"));
                quizList.add(new QuizzzModel("Harivansh Rai Bachchan", "Harivansh Rai Bachchan", "Ramdhari Singh Dinkar", "Sumitranandan Pant", "Jaishankar Prasad", "Who wrote the Hindi poem collection 'Madhushala'?"));


                setUp();
                break;

            case "Performing Arts":

                quizList.add(new QuizzzModel("Bharatanatyam", "Kathak", "Bharatanatyam", "Kuchipudi", "Mohiniyattam", "Which classical dance form originated in Tamil Nadu?"));
                quizList.add(new QuizzzModel("Natya Shastra", "Natya Shastra", "Rigveda", "Arthashastra", "Ramcharitmanas", "Which ancient Sanskrit text deals with theatre, dance, and music?"));
                quizList.add(new QuizzzModel("Sitar", "Sitar", "Tabla", "Veena", "Sarod", "Which instrument is associated with Pandit Ravi Shankar?"));
                quizList.add(new QuizzzModel("Kalidasa", "Kalidasa", "Bhasa", "Bhavabhuti", "Banabhatta", "Who wrote the Sanskrit play 'Malavikaagnimitram'?"));
                quizList.add(new QuizzzModel("Kathakali", "Kathak", "Bharatanatyam", "Kathakali", "Manipuri", "Which dance-drama is known for its elaborate makeup and masks, originating in Kerala?"));
                quizList.add(new QuizzzModel("Zubin Mehta", "Zubin Mehta", "Anoushka Shankar", "Alla Rakha", "Bismillah Khan", "Which Indian conductor is world-renowned for his work with Western classical orchestras?"));
                quizList.add(new QuizzzModel("Noh", "Kabuki", "Noh", "Butoh", "Bunraku", "Which is one of the oldest traditional forms of Japanese theatre?"));
                quizList.add(new QuizzzModel("Rukmini Devi Arundale", "Rukmini Devi Arundale", "Yamini Krishnamurthy", "Mallika Sarabhai", "Sonal Mansingh", "Who revived Bharatanatyam in the 20th century?"));
                quizList.add(new QuizzzModel("Beethoven", "Mozart", "Beethoven", "Chopin", "Bach", "Who composed the famous symphony 'Ode to Joy'?"));
                quizList.add(new QuizzzModel("Opera", "Opera", "Ballet", "Symphony", "Concerto", "Which performing art combines singing, acting, and orchestral music, often in grand theatres?"));


                setUp();
                break;









        }
    }

    private void setUp(){
        totalQues = 10;
        quizListSize = String.valueOf(totalQues);
        binding.totalQuestion.setText(quizListSize);

        if (position < totalQues) {
            positionNo = String.valueOf(position + 1);
            binding.questionNumber.setText(positionNo);
        } else {

            positionNo = String.valueOf(totalQues);
            binding.questionNumber.setText(positionNo);
        }

        if (position < totalQues) {
            quizzzModel = quizList.get(position);
            answer = quizzzModel.getCorrect();

            binding.questionContainer.setText(quizzzModel.getQuestion());
            binding.option1.setText(quizzzModel.getOptn1());
            binding.option2.setText(quizzzModel.getOptn2());
            binding.option3.setText(quizzzModel.getOptn3());
            binding.option4.setText(quizzzModel.getOptn4());

            optionChecker();
        }
    }

    private void optionChecker() {
        binding.option1.setOnClickListener(v->{
            if (Objects.equals(quizzzModel.getOptn1(),quizzzModel.getCorrect())){
                correct++;
                binding.option1.setBackgroundResource(R.drawable.corrcet_option);
                binding.option1.setTextColor(getContext().getColor(R.color.textcolroptions));
            }else{
                showCorrectAns();
                binding.option1.setBackgroundResource(R.drawable.wrong_option);
                binding.option1.setTextColor(getContext().getColor(R.color.textcolroptions));

            }
            DisableOption();
            binding.btnNext.setBackgroundResource(R.drawable.home_item);
        });
        binding.option2.setOnClickListener(v->{
            if (Objects.equals(quizzzModel.getOptn2(),quizzzModel.getCorrect())){
                correct++;
                binding.option2.setBackgroundResource(R.drawable.corrcet_option);
                binding.option2.setTextColor(getContext().getColor(R.color.textcolroptions));

            }else{
                showCorrectAns();
                binding.option2.setBackgroundResource(R.drawable.wrong_option);
                binding.option2.setTextColor(getContext().getColor(R.color.textcolroptions));

            }
            DisableOption();
            binding.btnNext.setBackgroundResource(R.drawable.home_item);
        });
        binding.option3.setOnClickListener(v->{
            if (Objects.equals(quizzzModel.getOptn3(),quizzzModel.getCorrect())){
                correct++;
                binding.option3.setBackgroundResource(R.drawable.corrcet_option);
                binding.option3.setTextColor(getContext().getColor(R.color.textcolroptions));

            }else{
                showCorrectAns();
                binding.option3.setBackgroundResource(R.drawable.wrong_option);
                binding.option3.setTextColor(getContext().getColor(R.color.textcolroptions));

            }
            DisableOption();
            binding.btnNext.setBackgroundResource(R.drawable.home_item);
        });
        binding.option4.setOnClickListener(v->{
            if (Objects.equals(quizzzModel.getOptn4(),quizzzModel.getCorrect())){
                correct++;
                binding.option4.setBackgroundResource(R.drawable.corrcet_option);
                binding.option4.setTextColor(getContext().getColor(R.color.textcolroptions));

            }else{
                showCorrectAns();
                binding.option4.setBackgroundResource(R.drawable.wrong_option);
                binding.option4.setTextColor(getContext().getColor(R.color.textcolroptions));

            }
            DisableOption();
            binding.btnNext.setBackgroundResource(R.drawable.home_item);

        });

    }
    private void DisableOption() {
        binding.option1.setEnabled(false);
        binding.option2.setEnabled(false);
        binding.option3.setEnabled(false);
        binding.option4.setEnabled(false);
        binding.btnNext.setEnabled(true);
    }

    private void showCorrectAns() {
        if (Objects.equals(quizzzModel.getOptn1(),quizzzModel.getCorrect())){
            binding.option1.setBackgroundResource(R.drawable.corrcet_option);
            binding.option1.setTextColor(getContext().getColor(R.color.textcolroptions));
        }else if(Objects.equals(quizzzModel.getOptn2(),quizzzModel.getCorrect())){
            binding.option2.setBackgroundResource(R.drawable.corrcet_option);
            binding.option2.setTextColor(getContext().getColor(R.color.textcolroptions));
        }else if (Objects.equals(quizzzModel.getOptn3(),quizzzModel.getCorrect())){
            binding.option3.setBackgroundResource(R.drawable.corrcet_option);
            binding.option3.setTextColor(getContext().getColor(R.color.textcolroptions));
        }else if (Objects.equals(quizzzModel.getOptn4(),quizzzModel.getCorrect())){
            binding.option4.setBackgroundResource(R.drawable.corrcet_option);
            binding.option4.setTextColor(getContext().getColor(R.color.textcolroptions));
        }
    }
}