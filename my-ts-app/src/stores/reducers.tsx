import {combineReducers} from 'redux';
import defaultState from './states'

function users (state: any[] = defaultState.users, action: { type: any; data: string; }){
    switch (action.type) {
        case 'SET_USER':
            console.log(action.data);
            return {state: state.push(action.data)}
        default:
            return state
    }
}

export default combineReducers({
    users
})