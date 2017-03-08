import java.util.HashMap;

public class SpamFilterMain
{
	public static void main(String[] args)
	{
		
		BagOfWords spamBag = new BagOfWords("spam.txt");


		
		System.out.println("Spam Total: " + spamBag.getBagTotal());
		System.out.println("spam Dict: " + spamBag.getBagDictSize());
		
		BagOfWords hamBag = new BagOfWords("ham.txt");

		
		System.out.println("Total: " + hamBag.getBagTotal());
		System.out.println("Dict: " + hamBag.getBagDictSize());
		
		SpamFilter filter = new SpamFilter("spam.txt","ham.txt");
	}
}
