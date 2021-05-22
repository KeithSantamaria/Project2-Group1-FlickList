

export default function reviewReducer( state = [], action) {
    if (action.type === 'reviewAdded') {
      return [
          ...state,
          {
              id: action.payload.id,
              userId: action.payload.userId,
              movieId: action.payload.movieId,
              date: action.payload.date,
              rating: action.payload.rating,
              title: action.payload.title,
              textBody: action.payload.textBody,
              likes: 0,
              dislikes: 0
          }
      ];
    } else if (action.type === 'reviewRemoved') {
        return state.filter(review => review.id !== action.payload.id);
    } else {
        return state;
    }
  }