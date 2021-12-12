
#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
	vector<int> goodDaysToRobBank(vector<int>& security, int time) {

		const int size = security.size();
		if (size < 2 * time + 1) {
			return vector<int>();
		}


		vector<int> result;
		if (time == 0) {
			for (int i = 0; i < size; i++) {
				result.push_back(i);
			}
			return result;
		}

		vector<int> goodDays(size, 0);
		int counterGoodDaysBefore = 0;
		for (int i = 1; i < size; i++) {
			if (security[i - 1] >= security[i]) {
				goodDays[i] = ++counterGoodDaysBefore;
			}
			else {
				counterGoodDaysBefore = 0;
			}
		}

		int counterGoodDaysAfter = 0;
		for (int i = size - 2; i >= 0; i--) {
			if (security[i + 1] >= security[i]) {
				if (min(goodDays[i], ++counterGoodDaysAfter) >= time) {
					result.push_back(i);
				}
			}
			else {
				counterGoodDaysAfter = 0;
			}
		}

		return result;
	}
};
