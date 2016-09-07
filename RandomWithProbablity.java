public class RandomItem{
    public String name;
    public double probability;
    public RandomItem(){ }
    public RandomItem(String t, double p){
        name = t;
        probability = p;
    }

    public String name() { return name; }
    public double probability() { return probability; }

    public static RandomItem randomSelector(RandomItem[] items) {
        double totalProbability = 0.0;
        for (RandomItem item : items) {
            totalProbability += item.probability;
        }
        RandomItem[] fixeditems = new RandomItem[items.length+1];
        System.arraycopy(items, 0, fixeditems, 1, items.length);
        fixeditems[0]=new RandomItem("",1-totalProbability);
        
        double p = Math.random();
        double cumulativeProbability = 0.0;
        
        for (RandomItem item : fixeditems) {
            cumulativeProbability += item.probability;
            if (p <= cumulativeProbability) {
                return item;
            }
        }
        return fixeditems[fixeditems.length];
        
    }

    public static void main(String[] args){
        for(int i=0;i<100;i++){}
            RandomItem[] materials = new RandomItem[]{
                new RandomItem("you won",0.1),
                new RandomItem("you lost",0.9)
            };
            System.out.println(randomSelector(materials).name);
        }
    }
    
}