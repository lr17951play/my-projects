import _data from '../data.json'
export function setUserStorage (userName: any){
    return (dispatch: (arg0: { type: string; data: any; }) => void) => {
        dispatch({ type: 'SET_USER', data: userName });
    }
}

export const getAllUsers = () => {
    let data = _data;
}