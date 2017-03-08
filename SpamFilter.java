import java.util.ArrayList;

public class SpamFilter
{
	private BagOfWords spamBag;
	private BagOfWords hamBag;
	private BagOfWords msgBag; //for laplace
	
	private Object[] spamWords;
	private Object[] hamWords;
	private ArrayList<Object> mixedBag; //spamBag words + hamBag words. i think this is just for the dictSize
	
	private int totalWords;
	private int dictSize;

	public SpamFilter(String spamFile, String hamFile)
	{
		spamBag = new BagOfWords(spamFile);
		hamBag = new BagOfWords(hamFile);
		//msgBag = new BagOfWords(message); place on solver, not on constructor
		
		spamWords = spamBag.getBagWords();
		hamWords = hamBag.getBagWords();
		
		totalWords = 0;
		
		mixedBag = new ArrayList<Object>();

		for(int i=0;i<spamWords.length;i++)
		{
			mixedBag.add(spamWords[i]);
		}
		
		for(int i=0;i<hamWords.length;i++)
		{
			if(mixedBag.contains(hamWords[i]) == false)
				mixedBag.add(hamWords[i]);
			else
				totalWords++;
		}
		
		dictSize = mixedBag.size();
		totalWords += dictSize;
		
		System.out.println("mixed total: " + totalWords);
		System.out.println("mixed dict: " + dictSize);

	}
}
