package ch.hslu.sw11.temperaturVerlauf;

import java.util.Objects;


public final class Temperatur implements Comparable<Temperatur> {

    public enum Unit {
        CELSIUS, KELVIN, FAHRENHEIT;
    }

    /**
     * Offset für die Umrechnung in Kelvin.
     */
    public static final float KELVIN_OFFSET = 273.15f;

    // Instanzvariable
    private final float tempCelsius;

    /**
     * Konstruktor für die Klasse Temperatur
     */
    private Temperatur() {
        // Instanzvariable initialisieren
        this.tempCelsius = 20f;
    }

    /**
     * Konstruktor für die Klasse Temperatur
     *
     * @param temp die Temperatur in Celsius
     */
    private Temperatur(final float temp) {
        if (temp > -273.15f){
            this.tempCelsius = temp;
        } else {
            throw new IllegalArgumentException("Keinen Gültigen Temperaturwert übergeben");
        }
    }

    /**
     * Konstruktor für die Klasse Temperatur
     *
     * @param temp die Temperatur in Celsius
     * @param unit die Einheit der Übergebenen Temperatur
     */
    private Temperatur(final float temp, final Unit unit) {
        switch (unit){
            case CELSIUS:
                this.tempCelsius = temp;
                break;

            case KELVIN:
                this.tempCelsius = convertKelvinToCelsius(temp);
                break;

            case FAHRENHEIT:
                this.tempCelsius = convertFahrenheitToCelsius(temp);
                break;

            default:
                this.tempCelsius = 20f;
                break;
        }
    }

    public static Temperatur createFromCelsius(final float celsius){
        return new Temperatur(celsius);
    }

    public static Temperatur createFromKelvin(final float kelvin){
        return new Temperatur(kelvin, Unit.KELVIN);
    }

    /**
     * Liefert die Temperatur in Celsius zurück.
     *
     * @return Temperatur in Celsius
     */
    public float getTempCelsius() {
        return this.tempCelsius;
    }

    /**
     * Liefert die Temperatur in Kelvin zurück.
     *
     * @return Temperatur in Kelvin
     */
    public float getTempKelvin() {
        return convertCelsiusToKelvin(this.tempCelsius);
    }

    /**
     * Liefert die Temperatur in Fahrenheit zurück.
     *
     * @return Temperatur in Fahrenheit
     */
    public float getTempFahrenheit() {
        return this.tempCelsius * 1.8f + 32;
    }

    /**
     * Konvertieren einer Temperatur in Kelvin zu Celsius
     *
     * @param kelvin die Temperatur in Kelvin
     */
    public static float convertKelvinToCelsius(final float kelvin){
        return kelvin - KELVIN_OFFSET;
    }

    /**
     * Konvertieren einer Temperatur in Celsius zu Kelvin
     *
     * @param celsius die Temperatur in Celsius
     */
    public static float convertCelsiusToKelvin(final float celsius){
        return celsius + KELVIN_OFFSET;
    }

    /**
     * Konvertieren einer Temperatur in Fahrenheit zu Celsius
     *
     * @param fahrenheit die Temperatur in Fahrenheit
     */
    public static float convertFahrenheitToCelsius(final float fahrenheit){
        return (fahrenheit - 32) / 1.8f;
    }

    /**
     * Konvertieren einer Temperatur in Celsius zu Fahrenheit
     *
     * @param celsius die Temperatur in Celsius
     */
    public static float convertCelsiusToFahrenheit(final float celsius){
        return celsius * 1.8f + 32;
    }

    /**
     * Liefert eine String-Repräsentation der Temperatur.
     * {@inheritDoc}.
     */
    @Override
    final public String toString() {
        return "Temperatur[tempCelsius=" + this.tempCelsius + "]";
    }

    /**
     * Überprüft ob Temperaturen gleich sind.
     * 1. Identität gleich
     * 2. Korrekter Typ
     * 3. Werte gleich
     * {@inheritDoc}.
     */
    @Override
    final public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Temperatur)) {
            return false;
        }
        final Temperatur other = (Temperatur) obj;

        return Float.compare(other.tempCelsius, this.tempCelsius) == 0;
    }

    /**
     * Liefert eine Hash-Repräsentation der Temperatur.
     * {@inheritDoc}.
     */
    @Override
    final public int hashCode() {
        return Objects.hash(this.tempCelsius);
    }

    /**
     * Vergleicht zwei Temperaturen miteinander.
     * {@inheritDoc}.
     */
    @Override
    public int compareTo(Temperatur other) {
        return Float.compare(this.tempCelsius, other.tempCelsius);
    }


}
