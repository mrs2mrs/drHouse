package diseasediagnosis;

public class SymptomProbabilityForDisease {
	
	private DiseaseSymptom symptom;
	private double[] probability = new double[4];
    private boolean isDiscovered = false;
    
    public SymptomProbabilityForDisease(DiseaseSymptom sym, double p0, double p1, double p2, double p3) {
        this.symptom = sym;
        this.probability[0] = p0;
        this.probability[1] = p1;
        this.probability[2] = p2;
        this.probability[3] = p3;
    }
    
    public double[] getProbability()
	{
		return probability;
	}
	
	public boolean getIsDiscovered()
	{
		return isDiscovered;
	}
	
	public void setIsDiscovered(boolean isD)
	{
		isDiscovered = isD;
	}

}
