package ua.lviv.iot.manager;

import java.util.ArrayList;
import java.util.Comparator;
import ua.lviv.iot.model.Securities;
import ua.lviv.iot.model.SortType;

public class SecuritiesManagerUtils {
	// Sorted with Static Inner Class
	private static final SecuritiesSorterByPrice SECURITIES_SORTER_BY_PRICE = new SecuritiesSorterByPrice();

	public static void sortByPrice(ArrayList<Securities> listOfSecurities, SortType sortType) {
		listOfSecurities.sort(
				sortType == SortType.ASCENDING ? SECURITIES_SORTER_BY_PRICE : SECURITIES_SORTER_BY_PRICE.reversed());
	}

	// Sorted with Inner Class
	public static void sortByLevelOfRisk(ArrayList<Securities> listOfSecurities, SortType sortType) {
		SecuritiesManagerUtils securitiesManager = new SecuritiesManagerUtils();
		SecuritiesSorterByRiskLevel sorterByRiskLevel = securitiesManager.new SecuritiesSorterByRiskLevel();
		listOfSecurities.sort(sortType == SortType.ASCENDING ? sorterByRiskLevel : sorterByRiskLevel.reversed());
	}

	// Sorted with anonymous class
	public static void sortByDocumentOwner(ArrayList<Securities> listOfSecurities, SortType sortType) {
		Comparator<Securities> comparator = new Comparator<Securities>() {
			@Override
			public int compare(Securities firstSecurity, Securities secondSecurity) {
				return firstSecurity.getDocumentOwner().compareTo(secondSecurity.getDocumentOwner());
			}
		};
		listOfSecurities.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
	}
	// Sorted with lambdas

	public static void sortByTrendOfBidding(ArrayList<Securities> listOfSecurities, SortType sortType) {

		Comparator<Securities> trendOfBiddingComparator = (Securities firstSecurity,
				Securities secondSecurity) -> firstSecurity.getTrendOfBidding().ordinal()
						- secondSecurity.getTrendOfBidding().ordinal();
		listOfSecurities
				.sort(sortType == SortType.ASCENDING ? trendOfBiddingComparator : trendOfBiddingComparator.reversed());

	}

	// Inner Class
	class SecuritiesSorterByRiskLevel implements Comparator<Securities> {
		@Override
		public int compare(Securities firstSecurity, Securities secondSecurity) {
			return firstSecurity.getLevelOfRisk().ordinal() - secondSecurity.getLevelOfRisk().ordinal();

		}
	}

	// Static Inner Class
	static class SecuritiesSorterByPrice implements Comparator<Securities> {
		@Override
		public int compare(Securities firstSecurity, Securities secondSecurity) {
			return firstSecurity.getPrice() - secondSecurity.getPrice();
		}

	}

}
