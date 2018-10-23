package com.dzeru.nightminesweeper.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class PhraseService
{
    @Autowired
    MessageSource messageSource;

    public ArrayList<String> createPhrases(ArrayList<ArrayList<Boolean>> field, int minesNear, int x, int y, Locale locale)
    {
        ArrayList<String> phrases = new ArrayList<>();

        String[] loc = new String[]{locale.getDisplayName(locale)};

        String noWay = messageSource.getMessage("phrase.noWay", loc, locale);
        String north = messageSource.getMessage("dir.north", loc, locale);
        String east = messageSource.getMessage("dir.east", loc, locale);
        String south = messageSource.getMessage("dir.south", loc, locale);
        String west = messageSource.getMessage("dir.west", loc, locale);

        String possibleMines = messageSource.getMessage("phrase.possibleMines", loc, locale);

        if(x == 0)
            phrases.add(noWay + west);
        if(x == field.get(y).size() - 1)
            phrases.add(noWay + east);
        if(y == 0)
            phrases.add(noWay + north);
        if(y == field.size() - 1)
            phrases.add(noWay + south);

        if(minesNear > 0)
            phrases.add(minesNear + " " + possibleMines);

        return phrases;
    }
}
