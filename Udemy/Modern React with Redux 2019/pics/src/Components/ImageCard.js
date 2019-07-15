import React from 'react'

class ImageCard extends React.Component {

    constructor(props) {
        super(props)

        this.imageRef = React.createRef();
    }

    state = {spans: 0};

    setSpans = () => {
        const heigth = this.imageRef.current.clientHeight;
        const spans = Math.ceil(heigth/10);

        this.setState( {spans} );
    }

    componentDidMount() {
        this.imageRef.current.addEventListener('load', this.setSpans);
    }


    render() {

        const {description, urls} = this.props.image;

        return (
            <div style={{gridRowEnd: `span ${this.state.spans}`}}>
                <img 
                    ref={this.imageRef}
                    alt={description} 
                    src={urls.regular}
                />
            </div>
        )
    }

}

export default ImageCard;