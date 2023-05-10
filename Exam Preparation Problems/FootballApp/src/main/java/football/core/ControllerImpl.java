package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplements = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field = null;
        if (fieldType.equals("ArtificialTurf")){
            field = new ArtificialTurf(fieldName);
            this.fields.add(field);
        }
        else if (fieldType.equals("NaturalGrass")){
            field = new NaturalGrass(fieldName);
            this.fields.add(field);
        }
        else {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement = null;
        if (type.equals("Powdered")){
            supplement = new Powdered();
            this.supplements.add(supplement);
        }
        else if (type.equals("Liquid")){
            supplement = new Liquid();
            this.supplements.add(supplement);
        }
        else {
            throw new NullPointerException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = this.supplements.findByType(supplementType);
        if (supplement != null){
            Field field = this.fields.stream().filter(field1 -> field1.getName().equals(fieldName)).
                    findFirst().orElse(null);
            if (field != null){
                field.addSupplement(supplement);
                this.supplements.remove(supplement);
            }
        }
        else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player = null;
        String typeOfField = null;
        if (playerType.equals("Men")){
            player = new Men(playerName, nationality, strength);
            typeOfField = "NaturalGrass";
        }
        else if (playerType.equals("Women")){
            player = new Women(playerName, nationality, strength);
            typeOfField = "ArtificialTurf";
        }
        else {
            throw new IllegalStateException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        Field field1 = this.fields.stream().filter(field -> field.getName().equals(fieldName)).findFirst().orElse(null);
        if (field1.getClass().getSimpleName().equals(typeOfField)){
            field1.addPlayer(player);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        }
        return ConstantMessages.FIELD_NOT_SUITABLE;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field currentField = this.fields.stream().filter(field -> field.getName().equals(fieldName)).
                findFirst().orElse(null);
        int sum = 0;

        if (currentField != null){
            for (Player player : currentField.getPlayers()){
                sum += 1;
            }
        }

        return String.format(ConstantMessages.PLAYER_DRAG, sum);
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field currentField = this.fields.stream().filter(field -> field.getName().equals(fieldName)).
                findFirst().orElse(null);

        int sum = 0;

        if (currentField != null){
            for (Player player : currentField.getPlayers()){
                sum += player.getStrength();
            }
        }
        return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Field field : this.fields){
            sb.append(field.getInfo().trim()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
