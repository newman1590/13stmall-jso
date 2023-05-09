<template>

    <v-data-table
        :headers="headers"
        :items="productsearch"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ProductsearchView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            productsearch : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/productsearches'))

            temp.data._embedded.productsearches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.productsearch = temp.data._embedded.productsearches;
        },
        methods: {
        }
    }
</script>

