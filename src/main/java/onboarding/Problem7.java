package onboarding;

import java.util.*;

public class Problem7 {
    private static Map<String,Integer> recommendedFriendScores =new HashMap<>();
    private static List<String> userFriendList =new ArrayList<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }

    private static void calculateRecommendedScoresWithVisitHistory(List<String> visitors){
        for(String visitor:visitors){
            if(!userFriendList.contains(visitor)){
                recommendedFriendScores.put(visitor, recommendedFriendScores.getOrDefault(visitor,0)+1);
            }
        }
    }

    private static void calculateRecommendedScoresWithFriendship(String user, List<List<String>> friends){
        for(List<String> friend: friends){

            //user 아이디와 친구 아이디가 같다면 다른 아이디는 이미 친구라는 의미이니 추천 친구 점수목록에서 삭제하고 친구 목록에 저장한다.
            String friendId=findUserFriendId(friend, user);
            if(!friendId.isBlank()){
                recommendedFriendScores.remove(friendId);
                userFriendList.add(friendId);
                continue;
            }

            addFriendScore(friend);
        }
    }

    private static String findUserFriendId(List<String> friend, String userId) {
        String friendId1=friend.get(0);
        String friendId2=friend.get(1);

        if(friendId1.equals(userId)){
            return friendId2;
        }
        if(friendId2.equals(userId)){
            return friendId1;
        }
        return "";
    }

    private static void addFriendScore(List<String> friend){
        friend.stream()
                .forEach(friendId -> recommendedFriendScores.put(friendId, recommendedFriendScores.getOrDefault(friendId,0)+10));
    }


}
