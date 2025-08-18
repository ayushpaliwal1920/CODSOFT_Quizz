package com.fristandroidproject.qizzz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fristandroidproject.qizzz.adapterclass.SubAdapter;
import com.fristandroidproject.qizzz.databinding.FragmentSubBinding;
import com.fristandroidproject.qizzz.modelclass.subScreenModel;

import java.util.ArrayList;

/** @noinspection ALL*/
public class SubFragment extends Fragment {

    FragmentSubBinding binding;
    ArrayList<subScreenModel> list = new ArrayList<>();
    String title;
    SubAdapter subAdapter;
    public SubFragment() {
    }

    public SubFragment(String title) {
        this.title = title;
    }




// In SubFragment.java
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate using ViewBinding
        binding = FragmentSubBinding.inflate(inflater, container, false);

        // Call loadData which configures the RecyclerView within this binding's view hierarchy
        loadData();

        // Return the root of the view hierarchy managed by the binding object
        return binding.getRoot();
    }

    private void loadData() {
        binding.rcvSub.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        switch (title) {
            case "Science":
                list.add(new subScreenModel("Science", "Study of matter, motion, energy, and forces.","Physics"));
                list.add(new subScreenModel("Science", "Composition, structure, and reactions of substances.","Chemistry"));
                list.add(new subScreenModel("Science", "Living organisms, their structures, and life processes.","Biology"));
                list.add(new subScreenModel("Science", "The universe beyond Earth, stars, planets, and galaxies.","Astronomy"));
                list.add(new subScreenModel("Science", "Ecosystems, pollution, and sustainability.","Environmental Science"));

                break;
            case "Mathematics":
                list.add(new subScreenModel("Mathematics", "Equations, expressions, and relationships of numbers.","Algebra"));
                list.add(new subScreenModel("Mathematics", "Shapes, sizes, and properties of space.","Geometry"));
                list.add(new subScreenModel("Mathematics", "Study of triangles and their angles.","Trigonometry"));
                list.add(new subScreenModel("Mathematics", "Change, motion, and advanced mathematical concepts.","Calculus"));
                list.add(new subScreenModel("Mathematics", "Data analysis, chance, and predictions.","Probability & Statistics"));

                break;
            case "Technology & Computers":
                list.add(new subScreenModel("Technology & Computers", "Basics of coding and software development.","Programming"));
                list.add(new subScreenModel("Technology & Computers", "Internet, protocols, and computer connections.","Networking"));
                list.add(new subScreenModel("Technology & Computers", "Protecting systems and data from threats.","Cyber Security"));
                list.add(new subScreenModel("Technology & Computers", "Machine learning and smart technologies","Artificial Intelligence"));
                list.add(new subScreenModel("Technology & Computers", "Storing, managing, and retrieving digital information.","Databases"));

                break;
            case "General Knowledge":
                list.add(new subScreenModel("General Knowledge", "Rules, players, and events from global sports.","Sports"));
                list.add(new subScreenModel("General Knowledge", "ontinents, countries, and natural features","Geography"));
                list.add(new subScreenModel("General Knowledge", "Leaders, scientists, and celebrities.","Famous Personalities"));
                list.add(new subScreenModel("General Knowledge", "Events, civilizations, revolutions, and key moments that shaped the world.","History"));
                list.add(new subScreenModel("General Knowledge", "Art, festivals, monuments, world heritage sites, traditions across countries.","Culture & Heritage"));

                break;
            case "Literature & Arts":
                list.add(new subScreenModel("Literature & Arts", "Famous writers, novels, and poetry","English Literature"));
                list.add(new subScreenModel("Literature & Arts", "Classics and modern works across the globe.","World Literature"));
                list.add(new subScreenModel("Literature & Arts", "Epics, modern works, and great authors","Indian Literature"));
                list.add(new subScreenModel("Literature & Arts", "Music, theatre, and dance","Performing Arts"));

                break;
            case "Current Affairs & Politics":
                list.add(new subScreenModel("Current Affairs & Politics", "Recent developments in India.","National News"));
                list.add(new subScreenModel("Current Affairs & Politics", "Global politics and agreements.","International News"));
                list.add(new subScreenModel("Current Affairs & Politics", "Laws, schemes, and reforms.","Government Policies"));
                list.add(new subScreenModel("Current Affairs & Politics", "Markets, budget, and trade.","Economy & Finance"));
                list.add(new subScreenModel("Current Affairs & Politics", "New inventions and space missions","Science & Tech News"));

                break;
            case "Mythology & Religion":
                list.add(new subScreenModel("Mythology & Religion", "Epics like Ramayana, Mahabharata, gods & goddesses.","Hindu Mythology"));
                list.add(new subScreenModel("Mythology & Religion", "Gods, heroes, and legendary tales.","Greek Mythology"));
                list.add(new subScreenModel("Mythology & Religion", "Thor, Odin, and ancient deities.","Roman & Norse Myths"));
                list.add(new subScreenModel("Mythology & Religion", "Teachings of Christianity, Islam, Buddhism,etc,","World Religions"));
                list.add(new subScreenModel("Mythology & Religion", "Vedas, Bible, Quran, Tripitaka.","Sacred Texts"));

                break;
            case "Health & Medicine":
                list.add(new subScreenModel("Health & Medicine", "Organs, systems, and body functions.","Human Anatomy"));
                list.add(new subScreenModel("Health & Medicine", "Common illnesses and cures.","Diseases & Treatment"));
                list.add(new subScreenModel("Health & Medicine", "Healthy eating and food science.","Nutrition & Diet"));
                list.add(new subScreenModel("Health & Medicine", "Emergency basics and safety.","First Aid"));
                list.add(new subScreenModel("Health & Medicine", "Vaccines, Nobel prizes, and innovations.","Medical Discoveries"));

                break;

            case "Logic & Puzzles":
                list.add(new subScreenModel("Logic & Puzzles", "Brain teasers and tricky questions.","Riddles"));
                list.add(new subScreenModel("Logic & Puzzles", "Sequences and logical patterns.","Pattern Recognition"));
                list.add(new subScreenModel("Logic & Puzzles", "Numbers and problem-solving.","Math Puzzles"));
                list.add(new subScreenModel("Logic & Puzzles", "Verbal, non-verbal, and analytical reasoning.","Reasoning"));
                list.add(new subScreenModel("Logic & Puzzles", "Decision-making and problem analysis.","Critical Thinking"));

                break;

            case "Entertainment & Pop Culture":
                list.add(new subScreenModel("Entertainment & Pop Culture", "Bollywood, Hollywood, and world cinema.","Movies"));
                list.add(new subScreenModel("Entertainment & Pop Culture", "Singers, bands, and genres.","Music"));
                list.add(new subScreenModel("Entertainment & Pop Culture", "Popular sitcoms, dramas, and reality shows.","TV Shows & Series"));
                list.add(new subScreenModel("Entertainment & Pop Culture", "Famous actors, musicians, and influencers.","Celebrities"));
                list.add(new subScreenModel("Entertainment & Pop Culture", "Video games, consoles, and eSports.","Gaming"));

                break;
        }
        subAdapter = new SubAdapter(getContext(),list);
        binding.rcvSub.setAdapter(subAdapter);
    }

}